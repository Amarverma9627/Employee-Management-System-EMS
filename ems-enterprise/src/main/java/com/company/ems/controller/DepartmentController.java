package com.company.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.ems.model.Department;
import com.company.ems.service.DepartmentService;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

  @Autowired
  private DepartmentService departmentService;

  @GetMapping
  public List<Department> getAllDepartments() {
    return departmentService.getAllDepartments();
  }

  @PostMapping
  public Department createDepartment(@RequestBody Department department) {
    return departmentService.saveDepartment(department);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
    Department department = departmentService.getDepartmentById(id);
    if (department == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(department);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @RequestBody Department departmentDetails) {
    Department updatedDepartment = departmentService.updateDepartment(id, departmentDetails);
    if (updatedDepartment == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(updatedDepartment);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteDepartment(@PathVariable Long id) {
    departmentService.deleteDepartment(id);
    return ResponseEntity.ok().build();
  }
 
}
