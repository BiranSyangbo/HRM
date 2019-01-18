package com.nepdroid.hrm.report.model;

import com.nepdroid.hrm.entity.AuditModel;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.GenericGenerator;

/**
 * This is a model class for Branch Report Model
 * with its getter and setter functions. 
 *
 * @author  Bipin Shrestha 
 * @version 1.0
 * @since   2019-01-06 
 */

@Entity
@Table(name = "branch")
public class BranchReportModel extends AuditModel {

  /**
   * This is serial UID version number.
   */
  private static final long serialVersionUID = -1183900308172267943L;

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

  @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY, 
      mappedBy = "branchReportModel")
  private LocationReportModel locationReportModel;

  @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY,
      mappedBy = "branchReportModel")
  private Set<DepartmentReportModel> departmentReportModel = new HashSet<>();

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
  
  public LocationReportModel getLocationReportModel() {
    return locationReportModel;
  }

  public void setLocationReportModel(LocationReportModel locationReportModel) {
    this.locationReportModel = locationReportModel;
  }
  
  public Set<DepartmentReportModel> getDepartmentReportModel() {
    return departmentReportModel;
  }

  public void setDepartmentReportModel(Set<DepartmentReportModel> departmentReportModel) {
    this.departmentReportModel = departmentReportModel;
  }

  @Override
  public String toString() {
    return "BranchReportModel [branchId=" + branchId + ", branchName=" + branchName + ","
      + "branchContact=" + branchContact + ", branchEmail=" + branchEmail + ", branchFaxNo="
      + branchFaxNo + ", locationReportModel=" + locationReportModel + ","
      + "departmentReportModel=" + departmentReportModel + "]";
  }

}
