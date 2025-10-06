package com.company.ems.service;

import com.company.ems.model.Attendance;
import com.company.ems.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceService {

  @Autowired
  private AttendanceRepository attendanceRepository;

  public List<Attendance> getAllAttendances() {
    return attendanceRepository.findAll();
  }

  public Attendance getAttendanceById(Long id) {
    return attendanceRepository.findById(id).orElse(null);
  }

  public Attendance saveAttendance(Attendance attendance) {
    return attendanceRepository.save(attendance);
  }

  public Attendance updateAttendance(Long id, Attendance attendanceDetails) {
    Attendance attendance = attendanceRepository.findById(id).orElse(null);
    if (attendance != null) {
      attendance.setDate(attendanceDetails.getDate());
      attendance.setCheckInTime(attendanceDetails.getCheckInTime());
      attendance.setCheckOutTime(attendanceDetails.getCheckOutTime());
      return attendanceRepository.save(attendance);
    }
    return null;
  }

  public void deleteAttendance(Long id) {
    attendanceRepository.deleteById(id);
  }
}
