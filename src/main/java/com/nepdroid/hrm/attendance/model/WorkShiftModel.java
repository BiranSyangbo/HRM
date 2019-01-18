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
 * This is a model class for Employee's Work Shift Details
 * with its getter and setter functions. 
 *
 * @author  Bipin Shrestha
 * @version 1.0
 * @since   2019-01-06 
 */
@Entity
@Table(name = "workshift")
public class WorkShiftModel extends AuditModel {

  /**
   * This is Serial UID version number.
   */
  private static final long serialVersionUID = -7110342949347825043L;

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "WORKSHIFT_ID")
  private String workshiftId;

  @Column(name = "WORKSHIFT_TYPE") 
  @NotNull
  private String workshiftType;

  @Column(name = "BREAK_HOURS")
  @NotNull
  private String breakHours;

  @Column(name = "START_TIME")
  @NotNull
  private String workshiftStartTime;

  @Column(name = "END_TIME")
  @NotNull
  private String workshiftEndTime;

  @Column(name = "WORKING_HOURS")
  @NotNull
  private String workingHours;

  @Column(name = "IS_OVERTIME_APPLICABLE")
  @NotNull
  private String isOvertimeApplicable;

  @Column(name = "OVERTIME_HOURS", nullable = true)
  private String overtimeHours;

  @Column(name = "DELETE_FLAG", nullable = true)
  private String deleteFlag;

  public String getWorkshiftId() {
    return workshiftId;
  }

  public void setWorkshiftId(String workshiftId) {
    this.workshiftId = workshiftId;
  }

  public String getWorkshiftType() {
    return workshiftType;
  }

  public void setWorkshiftType(String workshiftType) {
    this.workshiftType = workshiftType;
  }

  public String getBreakHours() {
    return breakHours;
  }

  public void setBreakHours(String breakHours) {
    this.breakHours = breakHours;
  }

  public String getWorkshiftStartTime() {
    return workshiftStartTime;
  }

  public void setWorkshiftStartTime(String workshiftStartTime) {
    this.workshiftStartTime = workshiftStartTime;
  }

  public String getWorkshiftEndTime() {
    return workshiftEndTime;
  }

  public void setWorkshiftEndTime(String workshiftEndTime) {
    this.workshiftEndTime = workshiftEndTime;
  }

  public String getWorkingHours() {
    return workingHours;
  }

  public void setWorkingHours(String workingHours) {
    this.workingHours = workingHours;
  }

  public String getIsOvertimeApplicable() {
    return isOvertimeApplicable;
  }

  public void setIsOvertimeApplicable(String isOvertimeApplicable) {
    this.isOvertimeApplicable = isOvertimeApplicable;
  }

  public String getOvertimeHours() {
    return overtimeHours;
  }

  public void setOvertimeHours(String overtimeHours) {
    this.overtimeHours = overtimeHours;
  }

  public String getDeleteFlag() {
    return deleteFlag;
  }

  public void setDeleteFlag(String deleteFlag) {
    this.deleteFlag = deleteFlag;
  }

  @Override
  public String toString() {
    return "WorkShiftModel [workshiftId=" + workshiftId + ", workshiftType=" + workshiftType + ", "
      + "breakHours=" + breakHours + ", workshiftStartTime=" + workshiftStartTime + ", "
      + "workshiftEndTime=" + workshiftEndTime + ", workingHours=" + workingHours + ", "
      + "isOvertimeApplicable=" + isOvertimeApplicable + ", overtimeHours=" + overtimeHours + "]";
  } 

}
