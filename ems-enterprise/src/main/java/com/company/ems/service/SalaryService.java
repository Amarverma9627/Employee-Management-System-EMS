package com.company.ems.service;

import com.company.ems.model.Salary;
import com.company.ems.repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryService {

  @Autowired
  private SalaryRepository salaryRepository;

  public List<Salary> getAllSalaries() {
    return salaryRepository.findAll();
  }

  public Salary getSalaryById(Long id) {
    return salaryRepository.findById(id).orElse(null);
  }

  public Salary saveSalary(Salary salary) {
    return salaryRepository.save(salary);
  }

  public Salary updateSalary(Long id, Salary salaryDetails) {
    Salary salary = salaryRepository.findById(id).orElse(null);
    if (salary != null) {
      salary.setBaseSalary(salaryDetails.getBaseSalary());
      salary.setBonus(salaryDetails.getBonus());
      salary.setSalaryMonth(salaryDetails.getSalaryMonth());
      return salaryRepository.save(salary);
    }
    return null;
  }

  public void deleteSalary(Long id) {
    salaryRepository.deleteById(id);
  }
}
