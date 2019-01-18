package com.nepdroid.hrm.attendance.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nepdroid.hrm.entity.AuditModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

/**
 * This is a model class for Company Employee's Attendance Details
 * with its getter and setter functions. 
 *
 * @author  Bipin Shrestha
 * @version 1.0
 * @since   2019-01-06 
 */
@Entity
@Table(name = "attendance")
public class AttendanceModel extends AuditModel {

  /**
   * This is Serial UID version number.
   */
  private static final long serialVersionUID = -8270171571898173741L;

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "ATTENDANCE_ID")
  private String attendanceId;

  @Column(name = "EMPLOYEE_ID")
  @NotNull
  private String employeeId;

  @Column(name = "START_TIME", nullable = true)
  private String attendanceStartTime;

  @Column(name = "END_TIME", nullable = true)
  private String attendanceEndTime;

  @Column(name = "ATTENDANCE_DATE", nullable = true)
  @JsonFormat(pattern = "yyyy-MM-dd")
  private String attendanceDate;

  @Column(name = "START_TIME_DIFFERENCE", nullable = true)
  private String startTimeDifference;

  @Column(name = "END_TIME_DIFFERENCE", nullable = true)
  private String endTimeDifference;
  
  @Column(name = "COMMENT")
  @NotNull
  private String comment;

  @Column(name = "APPROVED_BY")
  @NotNull
  private String approvedBy;

  @Column(name = "DELETE_FLAG", nullable = true)
  private String deleteFlag;

  public String getAttendanceId() {
    return attendanceId;
  }

  public void setAttendanceId(String attendanceId) {
    this.attendanceId = attendanceId;
  }

  public String getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(String employeeId) {
    this.employeeId = employeeId;
  }

  public String getAttendanceStartTime() {
    return attendanceStartTime;
  }

  public void setAttendanceStartTime(String attendanceStartTime) {
    this.attendanceStartTime = attendanceStartTime;
  }

  public String getAttendanceEndTime() {
    return attendanceEndTime;
  }

  public void setAttendanceEndTime(String attendanceEndTime) {
    this.attendanceEndTime = attendanceEndTime;
  }

  public String getAttendanceDate() {
    return attendanceDate;
  }

  public void setAttendanceDate(String attendanceDate) {
    this.attendanceDate = attendanceDate;
  }

  public String getStartTimeDifference() {
    return startTimeDifference;
  }

  public void setStartTimeDifference(String startTimeDifference) {
    this.startTimeDifference = startTimeDifference;
  }

  public String getEndTimeDifference() {
    return endTimeDifference;
  }

  public void setEndTimeDifference(String endTimeDifference) {
    this.endTimeDifference = endTimeDifference;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getApprovedBy() {
    return approvedBy;
  }

  public void setApprovedBy(String approvedBy) {
    this.approvedBy = approvedBy;
  }

  public String getDeleteFlag() {
    return deleteFlag;
  }

  public void setDeleteFlag(String deleteFlag) {
    this.deleteFlag = deleteFlag;
  }

  @Override
  public String toString() {
    return "AttendanceModel [attendanceId=" + attendanceId + ", employeeId=" + employeeId + ", "
      + "attendanceStartTime=" + attendanceStartTime + ", attendanceEndTime=" 
      + attendanceEndTime + ", " + "attendanceDate=" + attendanceDate + ", startTimeDifference=" 
      + startTimeDifference + ", endTimeDifference=" + endTimeDifference + ", "
      + "comment=" + comment + ", approvedBy=" + approvedBy + "]";
  } 
  
}
