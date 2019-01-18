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
 * This is a model class for Company Employee's Academic Details
 * with its getter and setter functions. 
 *
 * @author  Bipin Shrestha
 * @version 1.0
 * @since   2019-01-06 
 */

@Entity
@Table(name = "academic")
public class AcademicModel extends AuditModel {

  /**
   * During serialization, java runtime associates a version number with each serializable class. 
   * This number called serialVersionUID, which is used during deserialization to verify that 
   * the sender and receiver of a serialized object have loaded classes for that object that are 
   * compatible with respect to serialization.
   */
  private static final long serialVersionUID = -2823956482285325084L;

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "ACADEMIC_ID")
  private String academicId;

  @Column(name = "DEGREE_NAME")
  @NotNull(message = "Degree name is required")
  private String degreeName;

  @Column(name = "BOARD_UNIVERSITY")
  @NotNull(message = "Board or University is required")
  private String boardUniversity;

  @Column(name = "PASSED_YEAR")
  @NotNull(message = "Passed year is required")
  private String passedYear;

  @Column(name = "GRADE_PERCENTAGE")
  @NotNull(message = "Grade or Percentage is required")
  private String gradePercentage;

  @Column(name = "DELETE_FLAG", nullable = true)
  private String deleteFlag;
  
  @Column(name = "EMPLOYEE_ID")
  @NotNull
  private String employeeId;

  public String getAcademicId() {
    return academicId;
  }

  public void setAcademicId(String academicId) {
    this.academicId = academicId;
  }

  public String getDegreeName() {
    return degreeName;
  }

  public void setDegreeName(String degreeName) {
    this.degreeName = degreeName;
  }

  public String getBoardUniversity() {
    return boardUniversity;
  }

  public void setBoardUniversity(String boardUniversity) {
    this.boardUniversity = boardUniversity;
  }

  public String getPassedYear() {
    return passedYear;
  }

  public void setPassedYear(String passedYear) {
    this.passedYear = passedYear;
  }

  public String getGradePercentage() {
    return gradePercentage;
  }

  public void setGradePercentage(String gradePercentage) {
    this.gradePercentage = gradePercentage;
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
    return "AcademicModel [academicId=" + academicId + ", degreeName=" + degreeName + ","
      + "boardUniversity=" + boardUniversity + ", passedYear=" + passedYear + ","
      + "gradePercentage=" + gradePercentage + ", employeeId=" + employeeId + "]";
  }

}
