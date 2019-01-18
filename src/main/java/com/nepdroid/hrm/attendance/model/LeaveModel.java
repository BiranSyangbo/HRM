package com.nepdroid.hrm.attendance.model;

import com.nepdroid.hrm.entity.AuditModel;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.GenericGenerator;

/**
 * This is a model class for Employee's Leave Details
 * with its getter and setter functions. 
 *
 * @author  Bipin Shrestha
 * @version 1.0
 * @since   2019-01-06 
 */
@Entity
@Table(name = "emp_leave")
public class LeaveModel extends AuditModel {

  /**
   * This is Serial UID version number.
   */
  private static final long serialVersionUID = -1003968401973711590L;

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "LEAVE_ID")
  private String leaveId;

  @Column(name = "LEAVE_TYPE")
  @NotNull
  private String leaveType;

  @Column(name = "LEAVE_START_DATE")
  @NotNull
  private String leaveStartDate;

  @Column(name = "LEAVE_END_DATE")
  @NotNull
  private String leaveEndDate;

  @Column(name = "LEAVE_DAYS_TOTAL", nullable = true)
  private String leaveDaysTotal;

  @Column(name = "APPROVED_BY")
  @NotNull
  private String approvedBy;

  @Column(name = "COMMENT")
  @NotNull
  private String comment;

  @Column(name = "DELETE_FLAG", nullable = true)
  private String deleteFlag;

  @Column(name = "EMPLOYEE_ID", nullable = false)
  @NotNull
  private  String employeeId;

  public String getLeaveId() {
    return leaveId;
  }

  public void setLeaveId(String leaveId) {
    this.leaveId = leaveId;
  }

  public String getLeaveType() {
    return leaveType;
  }

  public void setLeaveType(String leaveType) {
    this.leaveType = leaveType;
  }

  public String getLeaveStartDate() {
    return leaveStartDate;
  }

  public void setLeaveStartDate(String leaveStartDate) {
    this.leaveStartDate = leaveStartDate;
  }

  public String getLeaveEndDate() {
    return leaveEndDate;
  }

  public void setLeaveEndDate(String leaveEndDate) {
    this.leaveEndDate = leaveEndDate;
  }

  public String getLeaveDaysTotal() {
    return leaveDaysTotal;
  }

  public void setLeaveDaysTotal(String leaveDaysTotal) {
    this.leaveDaysTotal = leaveDaysTotal;
  }

  public String getApprovedBy() {
    return approvedBy;
  }

  public void setApprovedBy(String approvedBy) {
    this.approvedBy = approvedBy;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getDeleteFlag() {
    return deleteFlag;
  }

  public void setDeleteFlag(String deleteFlag) {
    this.deleteFlag = deleteFlag;
  }

  public String getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(String employeeId) {
    this.employeeId = employeeId;
  }

  @Override
  public String toString() {
    return "LeaveModel [leaveId=" + leaveId + ", leaveType=" + leaveType + ", "
      + "leaveStartDate=" + leaveStartDate + ", leaveEndDate=" + leaveEndDate + ", "
      + "leaveDaysTotal=" + leaveDaysTotal + ", approvedBy=" + approvedBy
      + ", comment=" + comment + ", employeeId=" + employeeId + "]";
  }

}
