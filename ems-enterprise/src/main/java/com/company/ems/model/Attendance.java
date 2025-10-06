package com.company.ems.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "attendance")
public class Attendance {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "employee_id")
  private Employee employee;

  private LocalDate date;

  private LocalTime checkInTime;

  private LocalTime checkOutTime;

  public Attendance() {}

  // Getters and Setters

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }

  public Employee getEmployee() { return employee; }
  public void setEmployee(Employee employee) { this.employee = employee; }

  public LocalDate getDate() { return date; }
  public void setDate(LocalDate date) { this.date = date; }

  public LocalTime getCheckInTime() { return checkInTime; }
  public void setCheckInTime(LocalTime checkInTime) { this.checkInTime = checkInTime; }

  public LocalTime getCheckOutTime() { return checkOutTime; }
  public void setCheckOutTime(LocalTime checkOutTime) { this.checkOutTime = checkOutTime; }
}
