package com.nepdroid.hrm.report.repository;

import com.nepdroid.hrm.report.model.EmployeeReportModel;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeReportRepository extends JpaRepository<EmployeeReportModel, String> {
  
  Page<EmployeeReportModel> findByEmpId(String empId, Pageable pageable);
  
  Page<EmployeeReportModel> findByStartDateBetween(String startDate1, String startDate2, 
      Pageable pageable);
  
  @EntityGraph(value = "employeeReportModelOnly", type = EntityGraph.EntityGraphType.LOAD)
  Page<EmployeeReportModel> findByEmpIdAndAttendanceReportModelAttendanceDateBetween(String empId,
      String attendanceDate1, String attendanceDate2, Pageable pageable);

}
