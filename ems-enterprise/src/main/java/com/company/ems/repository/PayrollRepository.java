package com.company.ems.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.ems.model.Payroll;

public interface PayrollRepository extends JpaRepository<Payroll, Long> {
  Optional<Payroll> findByEmployeeId(Long employeeId);
}
