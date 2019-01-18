package com.nepdroid.hrm.report.controller;

import com.nepdroid.hrm.report.model.EmployeeReportModel;
import com.nepdroid.hrm.report.repository.EmployeeReportRepository;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
* This class program implements an application that simply performs 
* reporting generation operations for Employee Report Model.
* @author  Bipin Shrestha
* @version 1.0
* @since   2018-11-31 
*/
@RestController
public class EmployeeReportController {

  @Autowired
  private EmployeeReportRepository employeeReportRepository;

  /**
   * This is a method to get the whole report of all employee details.
   * @param pageable This is a parameter to getAllEmp method.
   * @return Page This returns response of whole report of all employee details.
   */
  @GetMapping("/empReport")
  public Page<EmployeeReportModel> getAllEmp(Pageable pageable) {
    return employeeReportRepository.findAll(pageable);
  }

  /**
   * This is a method to get the report of an employee by id.
   * @param empId This is a parameter to getEmpByEmpId method.
   * @param pageable This is a parameter to getEmpByEmpId method.
   * @return Page This returns response of report of an employee by id.
   */
  @GetMapping("/empReportByEmpId/{empId}")
  public Page<EmployeeReportModel> getEmpByEmpId(@PathVariable String empId, Pageable pageable) {
    return employeeReportRepository.findByEmpId(empId, pageable);
  }

  /**
   * This is a method to get the report of employees between start dates.
   * @param startDate1 This is a parameter to getEmpByStartDate method.
   * @param startDate2 This is a parameter to getEmpByStartDate method.
   * @param pageable This is a parameter to getEmpByStartDate method.
   * @return Page This returns response of report of an employee by id.
   */
  @GetMapping("/getEmpByStartDate/{startDate1}/{startDate2}")
  public Page<EmployeeReportModel> getEmpByStartDate(@PathVariable String startDate1,
      @PathVariable String startDate2, Pageable pageable) {
    return employeeReportRepository.findByStartDateBetween(startDate1, startDate2, pageable);
  }

  /**
   * This is a method to get the report of an employee by id 
   * with his/her attendance within certain period of time (attendance dates).
   * @param empId This is a parameter to getByEmpIdAndAttendanceReportModelAttendanceDate method.
   * @param attendanceDate1 This is a parameter to getByEmpIdAndAttendanceReportModelAttendanceDate 
   *     method.
   * @param attendanceDate2 This is a parameter to getByEmpIdAndAttendanceReportModelAttendanceDate 
   *     method.
   * @param pageable This is a parameter to getByEmpIdAndAttendanceReportModelAttendanceDate method.
   * @return Page This returns response of report of an employee by id with his/her attendance 
   *     within certain period of time (attendance dates).
   */
  @GetMapping("/getByEmpIdAndAttendanceReportModelAttendanceDate/{empId}/{attendanceDate1}/"
      + "{attendanceDate2}")
  public Page<EmployeeReportModel> getByEmpIdAndAttendanceReportModelAttendDate(@PathVariable 
      String empId, @PathVariable String attendanceDate1, @PathVariable String attendanceDate2, 
      Pageable pageable) {

    return employeeReportRepository.findByEmpIdAndAttendanceReportModelAttendanceDateBetween(empId,
        attendanceDate1, attendanceDate2, pageable);
  }

  /**
   * This is a method to get the report of employee by id 
   * with his/her attendance according to the month of given date.
   * @param empId This is a parameter to getByEmpIdAndAttendanceReportModelMonth method.
   * @param attendanceDate This is a parameter to getByEmpIdAndAttendanceReportModelMonth method. 
   * @param pageable This is a parameter to getByEmpIdAndAttendanceReportModelMonth method.
   * @return Page This returns response of report of employee by id with his/her attendance 
   *     according to the month of given date.
   */
  @GetMapping("/getByEmpIdAndAttendanceReportModelMonth/{empId}/{attendanceDate}")
  public Page<EmployeeReportModel> getByEmpIdAndAttendanceReportModelMonth(@PathVariable String 
      empId, @PathVariable String attendanceDate, Pageable pageable) {

    int count = 0;
    Page<EmployeeReportModel> data = null;
    try {
    
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
      Date localDate = dateFormat.parse(attendanceDate);
      LocalDate attendDate = localDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
      LocalDate firstOfMonth = attendDate.with(TemporalAdjusters.firstDayOfMonth());
      LocalDate lastOfMonth = attendDate.with(TemporalAdjusters.lastDayOfMonth());
      String firstDay = firstOfMonth.toString();
      String lastDay = lastOfMonth.toString();
      System.out.println(firstDay);
      System.out.println(lastDay);
      if (count == 0) {
        data = employeeReportRepository
               .findByEmpIdAndAttendanceReportModelAttendanceDateBetween(empId, 
                firstDay,lastDay, pageable);
        System.out.println("this is" + count + "    " + data.toString());
        count++;
      }
      
      /*
       * System.out.println(firstOfMonth); System.out.println(lastOfMonth);
       * System.out.println(attendanceDate);
       * System.out.println(attendDate.getMonthValue());
       */

    } catch (Exception ex) {
      System.out.println(ex.toString());
    }

    return data;

  }

}
