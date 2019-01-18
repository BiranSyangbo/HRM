package com.nepdroid.hrm.attendance.repository;

import com.nepdroid.hrm.attendance.model.AttendanceModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends JpaRepository<AttendanceModel, String> {
  
  AttendanceModel findByEmployeeIdAndAttendanceDate(String employeeId, String attendanceDate);
}
