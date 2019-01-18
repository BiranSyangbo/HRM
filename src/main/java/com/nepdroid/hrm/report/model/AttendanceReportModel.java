package com.nepdroid.hrm.report.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nepdroid.hrm.entity.AuditModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


/**
 * This is a model class for Employee Attendance Report Model
 * with its getter and setter functions. 
 *
 * @author  Bipin Shrestha
 * @version 1.0
 * @since   2019-01-06 
 */
@Entity
@Table(name = "attendance")
public class AttendanceReportModel extends AuditModel {

  /**
   * During serialization, java runtime associates a version number with each serializable class. 
   * This number called serialVersionUID, which is used during deserialization to verify that 
   * the sender and receiver of a serialized object have loaded classes for that object that are 
   * compatible with respect to serialization.
   */
  private static final long serialVersionUID = 9141633239109707384L;

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "ATTENDANCE_ID")
  private String attendanceId;

  @Column(name = "START_TIME", nullable = true)
  private String attendanceStartTime;

  @Column(name = "END_TIME", nullable = true)
  private String attendanceEndTime;

  @Column(name = "ATTENDANCE_DATE", nullable = true)
  @JsonFormat(pattern = "yyyy-MM-dd")
  private String attendanceDate;

  @Column(name = "COMMENT")
  @NotNull
  private String comment;

  @Column(name = "APPROVED_BY")
  @NotNull
  private String approvedBy;

  @Column(name = "START_TIME_DIFFERENCE", nullable = true)
  private String startTimeDifference;

  @Column(name = "END_TIME_DIFFERENCE", nullable = true)
  private String endTimeDifference;

  @Column(name = "DELETE_FLAG", nullable = true)
  private String deleteFlag;
  
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "EMPLOYEE_ID", nullable = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JsonIgnore
  private EmployeeReportModel employeeReportModel;

  public String getAttendanceId() {
    return attendanceId;
  }

  public void setAttendanceId(String attendanceId) {
    this.attendanceId = attendanceId;
  }

  public EmployeeReportModel getEmployeeReportModel() {
    return employeeReportModel;
  }

  public void setEmployeeReportModel(EmployeeReportModel employeeReportModel) {
    this.employeeReportModel = employeeReportModel;
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

  public String getDeleteFlag() {
    return deleteFlag;
  }

  public void setDeleteFlag(String deleteFlag) {
    this.deleteFlag = deleteFlag;
  }

  public String getAttendanceDate() {
    return attendanceDate;
  }

  public void setAttendanceDate(String attendanceDate) {
    this.attendanceDate = attendanceDate;
  }

  @Override
  public String toString() {
    return "AttendanceReportModel [attendanceId=" + attendanceId + ", employeeReportModel="
      + employeeReportModel + ", attendanceStartTime=" + attendanceStartTime + ", "
      + "attendanceEndTime=" + attendanceEndTime + ", attendanceDate=" + attendanceDate + ", "
      + "comment=" + comment + ", approvedBy=" + approvedBy + ", startTimeDifference="  
      + startTimeDifference + ", endTimeDifference=" + endTimeDifference + "]";
  }
  
}
