package com.nepdroid.hrm.company.model;

import com.nepdroid.hrm.entity.AuditModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

/**
* This is a model class for Company Sub Department 
* with its getter and setter functions. 
*
* @author  Bipin Shrestha
* @version 1.0
* @since   2019-01-06 
*/

@Entity
@Table(name = "sub_department")
public class SubDepartmentModel extends AuditModel {

  /**
   * During serialization, java runtime associates a version number with each serializable class. 
   * This number called serialVersionUID, which is used during deserialization to verify that 
   * the sender and receiver of a serialized object have loaded classes for that object that are 
   * compatible with respect to serialization.
   */
  private static final long serialVersionUID = 8852207603600614545L;

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

  @Column(name = "DEPARTMENT_ID")
  @NotNull
  private String departmentId;

  @Column(name = "DELETE_FLAG", nullable = true)
  private String deleteFlag;

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

  public String getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(String departmentId) {
    this.departmentId = departmentId;
  }

  public String getDeleteFlag() {
    return deleteFlag;
  }

  public void setDeleteFlag(String deleteFlag) {
    this.deleteFlag = deleteFlag;
  }

  @Override
  public String toString() {
    return "SubDepartmentModel [subDepartmentId=" + subDepartmentId + ", "
      + "subDepartmentName=" + subDepartmentName + ", subDepartmentAddress=" 
      + subDepartmentAddress + ", departmentId=" + departmentId + "]";
  }

}