package com.nepdroid.hrm.report.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nepdroid.hrm.entity.AuditModel;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * This is a model class for Department Report Model
 * with its getter and setter functions. 
 *
 * @author  Bipin Shrestha 
 * @version 1.0
 * @since   2019-01-06 
 */
@Entity
@Table(name = "department")
public class DepartmentReportModel extends AuditModel {

  /**
   * This is serial UID version number.
   */
  private static final long serialVersionUID = 1935041314318802959L;
  
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid",strategy = "uuid2")
  @Column(name = "DEPARTMENT_ID")
  private String departmentId; 
  
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "BRANCH_ID", nullable = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JsonIgnore
  private BranchReportModel branchReportModel;
  
  @Column(name = "DEPARTMENT_NAME", unique = true)
  @NotNull
  private String departmentName;
  
  @Column(name = "DEPARTMENT_ADDRESS")
  @NotNull
  private String departmentAddress;
  
  @Column(name = "DELETE_FLAG", nullable = true)
  private String deleteFlag;
  
  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true,
      mappedBy = "departmentReportModel") 
  private Set<SubDepartmentReportModel>  subDepartmentReportModel = new HashSet<>();


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
  
  public BranchReportModel getBranchReportModel() {
    return branchReportModel;
  }

  public void setBranchReportModel(BranchReportModel branchReportModel) {
    this.branchReportModel = branchReportModel;
  }

  public String getDeleteFlag() {
    return deleteFlag;
  }

  public void setDeleteFlag(String deleteFlag) {
    this.deleteFlag = deleteFlag;
  }
  
  
  public Set<SubDepartmentReportModel> getSubDepartmentReportModel() {
    return subDepartmentReportModel;
  }

  public void setSubDepartmentReportModel(Set<SubDepartmentReportModel> subDepartmentReportModel) {
    this.subDepartmentReportModel = subDepartmentReportModel;
  }

  @Override
  public String toString() {
    return "DepartmentReportModel [departmentId=" + departmentId + ", branchReportModel="
        + branchReportModel + ", subDepartmentReportModel=" + subDepartmentReportModel + ","
        + "departmentName=" + departmentName + ", departmentAddress=" + departmentAddress + "]";
  }

}
