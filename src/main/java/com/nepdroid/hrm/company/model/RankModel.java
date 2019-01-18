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
 * This is a model class for Company Employee Rank
 * with its getter and setter functions. 
 *
 * @author  Bipin Shrestha
 * @version 1.0
 * @since   2019-01-06 
 */
@Entity
@Table(name = "emp_rank")
public class RankModel extends AuditModel {

  /**
   * During serialization, java runtime associates a version number with each serializable class. 
   * This number called serialVersionUID, which is used during deserialization to verify that 
   * the sender and receiver of a serialized object have loaded classes for that object that are 
   * compatible with respect to serialization.
   */
  private static final long serialVersionUID = 6375408055594220400L;

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "RANK_ID")
  private String rankId;
  
  @Column(name = "RANK_NAME")
  @NotNull(message = "rank is required")
  private String rankName;
  
  @Column(name = "SALARY_RANGE") //range as 20000,50000 in front-end 
  @NotNull(message = "rank salary range is required")
  private String salaryRange;
  
  @Column(name = "DEPARTMENT_ID")
  @NotNull(message = "Department id is required")
  private String departmentId;

  @Column(name = "DELETE_FLAG", nullable = true)
  private String deleteFlag;

  
  public String getRankId() {
    return rankId;
  }


  public void setRankId(String rankId) {
    this.rankId = rankId;
  }

  public String getRankName() {
    return rankName;
  }


  public void setRankName(String rankName) {
    this.rankName = rankName;
  }


  public String getSalaryRange() {
    return salaryRange;
  }


  public void setSalaryRange(String salaryRange) {
    this.salaryRange = salaryRange;
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
    return "RankModel [rankId=" + rankId + ", rankName=" + rankName + ", "
      + "salaryRange=" + salaryRange + ", departmentId=" + departmentId + "]";
  }
}
