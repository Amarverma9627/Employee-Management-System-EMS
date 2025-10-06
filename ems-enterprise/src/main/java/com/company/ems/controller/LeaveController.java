package com.company.ems.controller;

import com.company.ems.model.Employee;
import com.company.ems.model.Leave;
import com.company.ems.model.Leave.LeaveStatus;
import com.company.ems.repository.EmployeeRepository;
import com.company.ems.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/leaves")
@CrossOrigin(origins = "http://localhost:5173")
public class LeaveController {

  @Autowired
  private LeaveRepository leaveRepo;

  @Autowired
  private EmployeeRepository employeeRepo;

  @GetMapping
  public List<Leave> getLeavesByStatus(@RequestParam(required = false) String status) {
    if (status == null || status.isEmpty()) {
      return leaveRepo.findAll();
    }
    LeaveStatus enumStatus;
    try {
      enumStatus = LeaveStatus.valueOf(status.toUpperCase());
    } catch (IllegalArgumentException e) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid status value");
    }
    return leaveRepo.findByStatus(enumStatus);
  }

  @PostMapping
  public Leave addLeave(@RequestBody Leave leave) {
    Long empId = leave.getEmployee().getId();
    Employee emp = employeeRepo.findById(empId)
            .orElseThrow(() -> new RuntimeException("Employee not found"));
    leave.setEmployee(emp);
    leave.setStatus(LeaveStatus.PENDING);
    return leaveRepo.save(leave);
  }

  @PutMapping("/{id}/approve")
  public Leave approveLeave(@PathVariable Long id) {
    Leave leave = leaveRepo.findById(id).orElseThrow();
    leave.setStatus(LeaveStatus.APPROVED);
    return leaveRepo.save(leave);
  }

  @PutMapping("/{id}/reject")
  public Leave rejectLeave(@PathVariable Long id) {
    Leave leave = leaveRepo.findById(id).orElseThrow();
    leave.setStatus(LeaveStatus.REJECTED);
    return leaveRepo.save(leave);
  }

  // New update leave endpoint to update leave details
  @PutMapping("/{id}")
  public ResponseEntity<Leave> updateLeave(@PathVariable Long id, @RequestBody Leave updatedLeave) {
    Optional<Leave> existingOpt = leaveRepo.findById(id);
    if (!existingOpt.isPresent()) {
      return ResponseEntity.notFound().build();
    }
    Leave existing = existingOpt.get();

    // Update fields - example: fromDate, toDate, reason
    existing.setFromDate(updatedLeave.getFromDate());
    existing.setToDate(updatedLeave.getToDate());
    existing.setReason(updatedLeave.getReason());

    // Optionally update status only if you want
    // existing.setStatus(updatedLeave.getStatus());

    Leave savedLeave = leaveRepo.save(existing);
    return ResponseEntity.ok(savedLeave);
  }

  // New delete leave endpoint to remove leave entry
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteLeave(@PathVariable Long id) {
    Optional<Leave> existingOpt = leaveRepo.findById(id);
    if (!existingOpt.isPresent()) {
      return ResponseEntity.notFound().build();
    }
    leaveRepo.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
