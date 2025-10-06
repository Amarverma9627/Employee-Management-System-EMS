package com.company.ems.model;

import jakarta.persistence.*;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "leaves")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Leave {

  public enum LeaveStatus {
    PENDING, APPROVED, REJECTED
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "employee_id")
  private Employee employee;

  private LocalDate fromDate;
  private LocalDate toDate;

  @Enumerated(EnumType.STRING)
  private LeaveStatus status;

  private String reason;

  public Leave() {}

  // Getters and Setters

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }

  public Employee getEmployee() { return employee; }
  public void setEmployee(Employee employee) { this.employee = employee; }

  public LocalDate getFromDate() { return fromDate; }
  public void setFromDate(LocalDate fromDate) { this.fromDate = fromDate; }

  public LocalDate getToDate() { return toDate; }
  public void setToDate(LocalDate toDate) { this.toDate = toDate; }

  public LeaveStatus getStatus() { return status; }
  public void setStatus(LeaveStatus status) { this.status = status; }

  public String getReason() { return reason; }
  public void setReason(String reason) { this.reason = reason; }
}
