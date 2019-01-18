package com.nepdroid.hrm.employee.model;

import com.nepdroid.hrm.entity.AuditModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.GenericGenerator;

/**
 * This is a model class for Company Employee's Bank Detail
 * with its getter and setter functions. 
 *
 * @author  Bipin Shrestha
 * @version 1.0
 * @since   2019-01-06 
 */
@Entity
@Table(name = "bank_detail")
public class BankDetailModel extends AuditModel {

  /**
   * During serialization, java runtime associates a version number with each serializable class. 
   * This number called serialVersionUID, which is used during deserialization to verify that 
   * the sender and receiver of a serialized object have loaded classes for that object that are 
   * compatible with respect to serialization.
   */
  private static final long serialVersionUID = -3165933327089450994L;

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "BANK_ID")
  private String bankId;

  @Column(name = "BANK_NAME")
  @NotNull
  private String bankName;

  @Column(name = "ACCOUNT_NAME")
  @NotNull
  private String accountName;

  @Column(name = "ACCOUNT_NUMBER", unique = true)
  @NotNull
  private String accountNumber;

  @Column(name = "BRANCH_NAME")
  @NotNull
  private String branchName;

  @Column(name = "DELETE_FLAG", nullable = true)
  private String deleteFlag;
  
  @Column(name = "EMPLOYEE_ID")
  @NotNull
  private String employeeId;

  public String getBankId() {
    return bankId;
  }

  public void setBankId(String bankId) {
    this.bankId = bankId;
  }

  public String getBankName() {
    return bankName;
  }

  public void setBankName(String bankName) {
    this.bankName = bankName;
  }

  public String getAccountName() {
    return accountName;
  }

  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public String getBranchName() {
    return branchName;
  }

  public void setBranchName(String branchName) {
    this.branchName = branchName;
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
    return "BankDetailModel [bankId=" + bankId + ", bankName=" + bankName + ", accountName="
      + accountName + ", accountNumber=" + accountNumber + ", branchName=" + branchName + ","
      + "employeeId=" + employeeId + "]";
  }

}
