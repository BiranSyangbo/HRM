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
 * This is a model class for Company Employee Promotion
 * with its getter and setter functions. 
 *
 * @author  Bipin Shrestha
 * @version 1.0
 * @since   2019-01-06 
 */
@Entity
@Table(name = "promotion")
public class PromotionModel extends AuditModel {

  /**
   * During serialization, java runtime associates a version number with each serializable class. 
   * This number called serialVersionUID, which is used during deserialization to verify that 
   * the sender and receiver of a serialized object have loaded classes for that object that are 
   * compatible with respect to serialization.
   */
  private static final long serialVersionUID = -2791466307593323647L;

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "PROMOTION_ID")
  private String promotionId;

  @Column(name = "EMPLOYEE_ID")
  @NotNull(message = "employee_id is required")
  private String employeeId;

  @Column(name = "PROMOTION_DATE")
  @NotNull(message = "promotion_date is required")
  private String promotionDate;

  @Column(name = "EFFECTIVE_DATE")
  @NotNull(message = "effective_date is required")
  private String effectiveDate;

  @Column(name = "COMMENT")
  @NotNull(message = "comment is required")
  private String comment;

  @Column(name = "BRANCH_ID")
  @NotNull(message = "branch_id is required")
  private String branchId;

  @Column(name = "DEPARTMENT_ID")
  @NotNull(message = "dept.id is required")
  private String departmentId;

  @Column(name = "RANK_ID")
  @NotNull(message = "rank_id is required")
  private String rankId;

  @Column(name = "DELETE_FLAG", nullable = true)
  private String deleteFlag;

  public String getPromotionId() {
    return promotionId;
  }

  public void setPromotionId(String promotionId) {
    this.promotionId = promotionId;
  }

  public String getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(String employeeId) {
    this.employeeId = employeeId;
  }

  public String getPromotionDate() {
    return promotionDate;
  }

  public void setPromotionDate(String promotionDate) {
    this.promotionDate = promotionDate;
  }

  public String getEffectiveDate() {
    return effectiveDate;
  }

  public void setEffectiveDate(String effectiveDate) {
    this.effectiveDate = effectiveDate;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
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

  public String getRankId() {
    return rankId;
  }

  public void setRankId(String rankId) {
    this.rankId = rankId;
  }

  public String getDeleteFlag() {
    return deleteFlag;
  }

  public void setDeleteFlag(String deleteFlag) {
    this.deleteFlag = deleteFlag;
  }

  @Override
  public String toString() {
    return "PromotionModel [promotionId=" + promotionId + ", employeeId=" + employeeId + ","
      + "promotionDate=" + promotionDate + ", effectiveDate=" + effectiveDate + ", comment="
      + comment + ", branchId=" + branchId + ", departmentId=" + departmentId + ", rankId="
      + rankId + "]";
  }
}
