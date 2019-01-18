package com.nepdroid.hrm.company.model;

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
 * This is a model class for Company Branch
 * with its getter and setter functions. 
 *
 * @author  Bipin Shrestha
 * @version 1.0
 * @since   2019-01-06 
 */
@Entity
@Table(name = "branch")
public class BranchModel extends AuditModel {

  /**
   * During serialization, java runtime associates a version number with each serializable class. 
   * This number called serialVersionUID, which is used during deserialization to verify that 
   * the sender and receiver of a serialized object have loaded classes for that object that are 
   * compatible with respect to serialization.
   */
  private static final long serialVersionUID = -2495368966580047204L;

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "BRANCH_ID")
  private String branchId;
  
  @Column(name = "BRANCH_NAME", unique = true)
  @NotNull
  private  String branchName;
  
  @Column(name = "BRANCH_CONTACT")
  @NotNull
  private String branchContact;
  
  @Column(name = "BRANCH_EMAIL", unique = true)
  @NotNull
  @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
      + "[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
      + "(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
      message = "Invalid Email")
  private String branchEmail;
  
  @Column(name = "BRANCH_FAX_NO")
  @NotNull
  private String branchFaxNo;

  @Column(name = "DELETE_FLAG", nullable = true)
  private String deleteFlag;

  public String getBranchId() {
    return branchId;
  }

  public void setBranchId(String branchId) {
    this.branchId = branchId;
  }

  public String getBranchName() {
    return branchName;
  }

  public void setBranchName(String branchName) {
    this.branchName = branchName;
  }

  public String getBranchContact() {
    return branchContact;
  }

  public void setBranchContact(String branchContact) {
    this.branchContact = branchContact;
  }

  public String getBranchEmail() {
    return branchEmail;
  }

  public void setBranchEmail(String branchEmail) {
    this.branchEmail = branchEmail;
  }

  public String getBranchFaxNo() {
    return branchFaxNo;
  }

  public void setBranchFaxNo(String branchFaxNo) {
    this.branchFaxNo = branchFaxNo;
  }

  public String getDeleteFlag() {
    return deleteFlag;
  }

  public void setDeleteFlag(String deleteFlag) {
    this.deleteFlag = deleteFlag;
  }

  @Override
  public String toString() {
    return "BranchModel [branchId=" + branchId + ", branchName=" + branchName + ", "
      + "branchContact=" + branchContact + ", branchEmail=" + branchEmail + ", "
      + "branchFaxNo=" + branchFaxNo + "]";
  } 

}

