package com.nepdroid.hrm.report.model;

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

/**
* This is a model class for Company Sub Department Report Model
* with its getter and setter functions. 
*
* @author  Bipin Shrestha
* @version 1.0
* @since   2019-01-06 
*/

@Entity
@Table(name = "sub_department")
public class SubDepartmentReportModel extends AuditModel {

  /**
   * This is serial UID version number.
   */
  private static final long serialVersionUID = 8833315151307105859L;
  
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid",strategy = "uuid2")
  @Column(name = "SUB_DEPARTMENT_ID")
  private String subDepartmentId; 

  @Column(name = "SUB_DEPARTMENT_NAME", unique = true)
  @NotNull
  private String subDepartmentName;

  @Column(name = "SUB_DEPARTMENT_ADDRESS")
  @NotNull
  private String subDepartmentAddress;

  @Column(name = "DELETE_FLAG", nullable = true)
  private String deleteFlag;
  
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "DEPARTMENT_ID", nullable = false)
  @JsonIgnore
  private DepartmentReportModel departmentReportModel;

  public String getSubDepartmentId() {
    return subDepartmentId;
  }

  public void setSubDepartmentId(String subDepartmentId) {
    this.subDepartmentId = subDepartmentId;
  }

  public String getSubDepartmentName() {
    return subDepartmentName;
  }

  public void setSubDepartmentName(String subDepartmentName) {
    this.subDepartmentName = subDepartmentName;
  }

  public String getSubDepartmentAddress() {
    return subDepartmentAddress;
  }

  public void setSubDepartmentAddress(String subDepartmentAddress) {
    this.subDepartmentAddress = subDepartmentAddress;
  }

  public String getDeleteFlag() {
    return deleteFlag;
  }

  public void setDeleteFlag(String deleteFlag) {
    this.deleteFlag = deleteFlag;
  }

  public DepartmentReportModel getDepartmentReportModel() {
    return departmentReportModel;
  }

  public void setDepartmentReportModel(DepartmentReportModel departmentReportModel) {
    this.departmentReportModel = departmentReportModel;
  }

  @Override
  public String toString() {
    return "SubDepartmentReportModel [subDepartmentId=" + subDepartmentId + ","
      + "subDepartmentName=" + subDepartmentName + ", subDepartmentAddress="
      + subDepartmentAddress + ", " + "departmentReportModel=" + departmentReportModel + "]";
  }
  
}
