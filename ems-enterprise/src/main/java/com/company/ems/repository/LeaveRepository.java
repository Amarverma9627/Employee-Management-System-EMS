package com.company.ems.repository;

import com.company.ems.model.Leave;
import com.company.ems.model.Leave.LeaveStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LeaveRepository extends JpaRepository<Leave, Long> {
  List<Leave> findByStatus(LeaveStatus status);
}
