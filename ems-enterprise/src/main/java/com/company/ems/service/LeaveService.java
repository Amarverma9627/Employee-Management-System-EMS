package com.company.ems.service;

import com.company.ems.model.Leave;
import com.company.ems.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveService {

  @Autowired
  private LeaveRepository leaveRepository;

  public List<Leave> getAllLeaves() {
    return leaveRepository.findAll();
  }

  public Leave getLeaveById(Long id) {
    return leaveRepository.findById(id).orElse(null);
  }

  public Leave saveLeave(Leave leave) {
    return leaveRepository.save(leave);
  }

  public Leave updateLeave(Long id, Leave leaveDetails) {
    Leave leave = leaveRepository.findById(id).orElse(null);
    if (leave != null) {
      leave.setFromDate(leaveDetails.getFromDate());
      leave.setToDate(leaveDetails.getToDate());
      leave.setStatus(leaveDetails.getStatus());
      leave.setReason(leaveDetails.getReason());
      return leaveRepository.save(leave);
    }
    return null;
  }

  public void deleteLeave(Long id) {
    leaveRepository.deleteById(id);
  }
}
