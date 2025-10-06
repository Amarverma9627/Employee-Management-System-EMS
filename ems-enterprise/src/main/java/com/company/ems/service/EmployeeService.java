package com.company.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.company.ems.model.Employee;
import com.company.ems.repository.EmployeeRepository;

@Service
public class EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

 

  public Employee getEmployeeById(Long id) {
    return employeeRepository.findById(id).orElse(null);
  }

  public Employee saveEmployee(Employee employee) {
    return employeeRepository.save(employee);
  }

  public Employee updateEmployee(Long id, Employee employeeDetails) {
    Employee employee = employeeRepository.findById(id).orElse(null);
    if (employee != null) {
      employee.setFirstName(employeeDetails.getFirstName());
      employee.setLastName(employeeDetails.getLastName());
      employee.setEmail(employeeDetails.getEmail());
      employee.setDepartment(employeeDetails.getDepartment());
      employee.setSalary(employeeDetails.getSalary());
      return employeeRepository.save(employee);
    }
    return null;
  }
  @GetMapping("/api/employees")
  public List<Employee> getAllEmployees() {
      return employeeRepository.findAll();
  }

  public void deleteEmployee(Long id) {
    employeeRepository.deleteById(id);
  }
}
