package com.nepdroid.hrm.employee.model;

import com.nepdroid.hrm.entity.AuditModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.GenericGenerator;


/**
 * This is a model class for Company Employee's Employment History
 * with its getter and setter functions. 
 *
 * @author  Bipin Shrestha
 * @version 1.0
 * @since   2019-01-06 
 */
@Entity
@Table(name = "employment_history")
public class EmploymentHistoryModel extends AuditModel {

  /**
   *During serialization, java runtime associates a version number with each serializable class. 
   * This number called serialVersionUID, which is used during deserialization to verify that 
   * the sender and receiver of a serialized object have loaded classes for that object that are 
   * compatible with respect to serialization.
   */
  private static final long serialVersionUID = -1788411015267715826L;

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "EMPLOYMENT_HISTORY_ID")
  private String employmentHistoryId;
  
  @Column(name = "ORGANIZATION")
  @NotNull
  private String organization;

  @Column(name = "JOB_TITLE")
  @NotNull
  private String jobTitle;

  @Column(name = "WORK_START_DATE")
  @NotNull
  @Pattern(regexp = "\\d{9}|\\d{10}")
  private String workStartDate;

  @Column(name = "WORK_END_DATE")
  @NotNull
  @Pattern(regexp = "\\d{9}|\\d{10}")
  private String workEndDate;

  @Column(name = "EXPERIENCE")
  @NotNull
  private String experience;

  @Column(name = "DELETE_FLAG", nullable = true)
  private String deleteFlag;
  
  @Column(name = "EMPLOYEE_ID")
  @NotNull
  private String employeeId;

  public String getEmploymentHistoryId() {
    return employmentHistoryId;
  }

  public void setEmploymentHistoryId(String employmentHistoryId) {
    this.employmentHistoryId = employmentHistoryId;
  }

  public String getOrganization() {
    return organization;
  }

  public void setOrganization(String organization) {
    this.organization = organization;
  }

  public String getJobTitle() {
    return jobTitle;
  }

  public void setJobTitle(String jobTitle) {
    this.jobTitle = jobTitle;
  }

  public String getWorkStartDate() {
    return workStartDate;
  }

  public void setWorkStartDate(String workStartDate) {
    this.workStartDate = workStartDate;
  }

  public String getWorkEndDate() {
    return workEndDate;
  }

  public void setWorkEndDate(String workEndDate) {
    this.workEndDate = workEndDate;
  }

  public String getExperience() {
    return experience;
  }

  public void setExperience(String experience) {
    this.experience = experience;
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
    return "EmploymentHistoryModel [employmentHistoryId=" + employmentHistoryId + ", organization="
      + organization + ", jobTitle=" + jobTitle + ", workStartDate=" + workStartDate + ","
      + "workEndDate=" + workEndDate + ", experience=" + experience + ", employeeId=" 
      + employeeId + "]";
  }
}
