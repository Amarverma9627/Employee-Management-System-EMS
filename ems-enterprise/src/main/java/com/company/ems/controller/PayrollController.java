package com.company.ems.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.company.ems.model.Payroll;
import com.company.ems.service.PayrollService;

@RestController
@RequestMapping("/api/payrolls")
@CrossOrigin(origins = "http://localhost:5173")
public class PayrollController {

  private final PayrollService payrollService;

  public PayrollController(PayrollService payrollService) {
    this.payrollService = payrollService;
  }
  
  @GetMapping
  public List<Payroll> getAllPayrolls() {
    return payrollService.getAllPayrolls();
  }
 

  @PostMapping
  public Payroll addPayroll(@RequestBody Payroll payroll) {
    return payrollService.addPayroll(payroll);
  }
  
  // **NEW: Get payroll by employeeId**
  @GetMapping("/{employeeId}")
  public Payroll getPayrollByEmployeeId(@PathVariable Long employeeId) {
    Payroll payroll = payrollService.getPayrollByEmployeeId(employeeId);
    if (payroll == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Payroll not found for Employee ID: " + employeeId);
    }
    return payroll;
  }
}
