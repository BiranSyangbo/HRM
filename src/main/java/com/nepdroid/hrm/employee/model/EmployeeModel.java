package com.nepdroid.hrm.employee.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nepdroid.hrm.entity.AuditModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;


/**
 * This is a model class for Company Employee Model
 * with its getter and setter functions. 
 *
 * @author  Bipin Shrestha
 * @version 1.0
 * @since   2019-01-06 
 */
@Entity
@Table(name = "employee")
public class EmployeeModel  extends AuditModel {

  /**
   *During serialization, java runtime associates a version number with each serializable class. 
   * This number called serialVersionUID, which is used during deserialization to verify that 
   * the sender and receiver of a serialized object have loaded classes for that object that are 
   * compatible with respect to serialization.
   * If the receiver has loaded a class for the object that has a different serialVersionUID 
   * than that of the corresponding sender’s class, then deserialization will result 
   * in an InvalidClassException.
   */
  private static final long serialVersionUID = -1648421999279292076L;

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "EMPLOYEE_ID")
  private String employeeId;

  @Column(name = "PAN_NO")
  @NotNull
  private String panNo;

  @Column(name = "FIRST_NAME")
  @NotNull(message = "First name is a required field")
  @Size(min = 1, max = 60, message = "First name cannot be longer than 60 characters")
  private String firstName;

  @Column(name = "MIDDLE_NAME", nullable = true)
  @Size(min = 1, max = 60, message = "Middle name cannot be longer than 60 characters")
  private String middleName;

  @Column(name = "LAST_NAME")
  @NotNull(message = "Last name is a required field")
  @Size(min = 1, max = 60, message = "Last name cannot be longer than 60 characters")
  private String lastName;

  @Column(name = "GENDER")
  @NotNull
  private String gender;

  @Column(name = "DOB")
  @NotNull
  @JsonFormat(pattern = "yyyy-MM-dd")
  private String dob;

  @Column(name = "BLOOD_GROUP")
  @NotNull
  private String bloodGroup;

  @Column(name = "START_DATE")
  @NotNull
  @JsonFormat(pattern = "yyyy-MM-dd")
  private String startDate;

  @Column(name = "END_DATE", nullable = true)
  @JsonFormat(pattern = "yyyy-MM-dd")
  private String endDate;

  @Column(name = "CONTRACT_PERIOD", nullable = true)
  private String contractPeriod;

  @Column(name = "EMP_GROUP")
  @NotNull
  private String empGroup;

  @Column(name = "SERVICE_TYPE")
  @NotNull
  private String serviceType;

  @Column(name = "RANK_ID")
  @NotNull
  private String rankId;

  @Column(name = "BRANCH_ID")
  @NotNull
  private String branchId;
  
  @Column(name = "DEPARTMENT_ID")
  @NotNull
  private String departmentId;

  @Column(name = "REPORTS_TO")
  @NotNull
  private String reportsTo;

  @Column(name = "INCOME_TAX_STATUS")
  @NotNull
  private String incomeTaxStatus;

  @Column(name = "NATIONAL_ID")
  @NotNull
  private String nationalId;

  @Column(name = "NATIONALITY")
  @NotNull
  private String nationality;


  @Column(name = "WORKSHIFT_ID")
  @NotNull
  private  String workshiftId;


  @Column(name = "DELETE_FLAG", nullable = true)
  private String deleteFlag;

  public String getEmployeeId() {
    return employeeId;
  }
  
  public void setEmployeeId(String employeeId) {
    this.employeeId = employeeId;
  }

  public String getPanNo() {
    return panNo;
  }

  public void setPanNo(String panNo) {
    this.panNo = panNo;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getDob() {
    return dob;
  }

  public void setDob(String dob) {
    this.dob = dob;
  }

  public String getBloodGroup() {
    return bloodGroup;
  }

  public void setBloodGroup(String bloodGroup) {
    this.bloodGroup = bloodGroup;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }
 
  public String getContractPeriod() {
    return contractPeriod;
  }

  public void setContractPeriod(String contractPeriod) {
    this.contractPeriod = contractPeriod;
  }

  public String getEmpGroup() {
    return empGroup;
  }
  
  public void setEmpGroup(String empGroup) {
    this.empGroup = empGroup;
  }

  public String getServiceType() {
    return serviceType;
  }

  public void setServiceType(String serviceType) {
    this.serviceType = serviceType;
  }

  public String getRankId() {
    return rankId;
  }

  public void setRankId(String rankId) {
    this.rankId = rankId;
  }

  public String getBranchId() {
    return branchId;
  }

  public void setBranchId(String branchId) {
    this.branchId = branchId;
  }

  public String getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(String departmentId) {
    this.departmentId = departmentId;
  }

  public String getReportsTo() {
    return reportsTo;
  }

  public void setReportsTo(String reportsTo) {
    this.reportsTo = reportsTo;
  }

  public String getIncomeTaxStatus() {
    return incomeTaxStatus;
  }

  public void setIncomeTaxStatus(String incomeTaxStatus) {
    this.incomeTaxStatus = incomeTaxStatus;
  }

  public String getNationalId() {
    return nationalId;
  }

  public void setNationalId(String nationalId) {
    this.nationalId = nationalId;
  }

  public String getNationality() {
    return nationality;
  }

  public void setNationality(String nationality) {
    this.nationality = nationality;
  }

  public String getWorkshiftId() {
    return workshiftId;
  }

  public void setWorkshiftId(String workshiftId) {
    this.workshiftId = workshiftId;
  }

  public String getDeleteFlag() {
    return deleteFlag;
  }

  public void setDeleteFlag(String deleteFlag) {
    this.deleteFlag = deleteFlag;
  }

  @Override
  public String toString() {
    return "EmployeeModel [employeeId=" + employeeId + ", panNo=" + panNo + ", firstName=" 
      + firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", gender=" 
      + gender + ", dob=" + dob + ", bloodGroup=" + bloodGroup + ", startDate=" + startDate + ","
      + "endDate=" + endDate + ", contractPeriod=" + contractPeriod + ", empGroup=" + empGroup + ","
      + "serviceType=" + serviceType + ", rankId=" + rankId + ", branchId=" + branchId + ", "
      + "departmentId=" + departmentId + ", reportsTo=" + reportsTo + ", incomeTaxStatus=" 
      + incomeTaxStatus + ", nationalId=" + nationalId + ", nationality=" + nationality + ","
      + "workshiftId=" + workshiftId + "]";
  }  
}

/*    //getter method to retrieve the DptId
    public String getDpt_id(){
        return employeeDepartment.getDepartment_id();
    }
  
    public String getJb_id(){
        return employeeJob.getJob_id();
    }
    
   //getter Method to get the author's full name
    public String getAuthorName(){
        return author.getFirstName() + " " + author.getLastName();
}*/





