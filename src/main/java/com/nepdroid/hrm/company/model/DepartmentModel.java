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
 * This is a model class for Company Department
 * with its getter and setter functions. 
 *
 * @author  Bipin Shrestha
 * @version 1.0
 * @since   2019-01-06 
 */

@Entity
@Table(name = "department")
public class DepartmentModel extends AuditModel {

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
  @Column(name = "DEPARTMENT_ID")
  private String departmentId; 

  @Column(name = "DEPARTMENT_NAME", unique = true)
  @NotNull
  private String departmentName;
  
  @Column(name = "DEPARTMENT_ADDRESS")
  @NotNull
  private String departmentAddress;
  
  @Column(name = "BRANCH_ID")
  @NotNull
  private String branchId;
  
  @Column(name = "DELETE_FLAG", nullable = true)
  private String deleteFlag;

  public String getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(String departmentId) {
    this.departmentId = departmentId;
  }

  public String getDepartmentName() {
    return departmentName;
  }

  public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
  }

  public String getDepartmentAddress() {
    return departmentAddress;
  }

  public void setDepartmentAddress(String departmentAddress) {
    this.departmentAddress = departmentAddress;
  }

  public String getBranchId() {
    return branchId;
  }

  public void setBranchId(String branchId) {
    this.branchId = branchId;
  }

  public String getDeleteFlag() {
    return deleteFlag;
  }

  public void setDeleteFlag(String deleteFlag) {
    this.deleteFlag = deleteFlag;
  }

  @Override
  public String toString() {
    return "DepartmentModel [departmentId=" + departmentId + ", "
      + "departmentName=" + departmentName + ", departmentAddress=" 
      + departmentAddress + ", branchId=" + branchId + "]";
  } 
  
}
    
    
 
