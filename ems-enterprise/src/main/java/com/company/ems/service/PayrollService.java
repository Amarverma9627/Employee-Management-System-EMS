package com.company.ems.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.company.ems.model.Payroll;
import com.company.ems.repository.PayrollRepository;

@Service
public class PayrollService {

  private final PayrollRepository payrollRepository;

  public PayrollService(PayrollRepository payrollRepository) {
    this.payrollRepository = payrollRepository;
  }

  public List<Payroll> getAllPayrolls() {
    return payrollRepository.findAll();
  }

  public Payroll addPayroll(Payroll payroll) {
    return payrollRepository.save(payroll);
  }
  // **NEW: Get payroll by employeeId**
  public Payroll getPayrollByEmployeeId(Long employeeId) {
    return payrollRepository.findByEmployeeId(employeeId).orElse(null);
  }
}
