package com.company.ems.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "payrolls")
public class Payroll {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(name = "employee_id", nullable = false)
  private Long employeeId;
  
  @Column(name = "base_salary")
  private BigDecimal baseSalary;
  
  @Column(name = "bonus")
  private BigDecimal bonus;
  
  @Column(name = "salary_month")
  private LocalDate salaryMonth;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public Long getEmployeeId() {
	return employeeId;
}

public void setEmployeeId(Long employeeId) {
	this.employeeId = employeeId;
}

public BigDecimal getBaseSalary() {
	return baseSalary;
}

public void setBaseSalary(BigDecimal baseSalary) {
	this.baseSalary = baseSalary;
}

public BigDecimal getBonus() {
	return bonus;
}

public void setBonus(BigDecimal bonus) {
	this.bonus = bonus;
}

public LocalDate getSalaryMonth() {
	return salaryMonth;
}

public void setSalaryMonth(LocalDate salaryMonth) {
	this.salaryMonth = salaryMonth;
}

  

}
