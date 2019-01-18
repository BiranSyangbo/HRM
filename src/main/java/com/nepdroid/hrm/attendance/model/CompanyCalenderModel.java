package com.nepdroid.hrm.attendance.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nepdroid.hrm.entity.AuditModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.GenericGenerator;

/**
 * This is a model class for Company Calender Details
 * with its getter and setter functions. 
 *
 * @author  Bipin Shrestha
 * @version 1.0
 * @since   2019-01-06 
 */
@Entity
@Table(name = "company_calender")
public class CompanyCalenderModel extends AuditModel {

  /**
   * This is Serial UID version number.
   */
  private static final long serialVersionUID = 5585237940074548935L;

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "COMPANY_CALENDER_ID")
  private String companyCalenderId;

  @Column(name = "TITLE", nullable = false)
  @NotNull(message = "Title is required")
  private String title;

  @Column(name = "DATE_FROM", nullable = false)
  @NotNull(message = "Date_from is required")
  @JsonFormat(pattern = "yyyy-MM-dd")
  private String dateFrom;

  @Column(name = "DATE_TO", nullable = false)
  @NotNull(message = "Date_to is required")
  @JsonFormat(pattern = "yyyy-MM-dd")
  private String dateTo;

  @Column(name = "TOTAL_HOLIDAY", nullable = true)
  private String totalHoliday;

  @Column(name = "TYPE", nullable = false)
  @NotNull(message = "Type is required")
  private String type;

  @Column(name = "COMMENT", nullable = false)
  @NotNull(message = "Comment is required")
  private String comment;

  @Column(name = "DELETE_FLAG", nullable = true)
  private String deleteFlag;

  public String getCompanyCalenderId() {
    return companyCalenderId;
  }

  public void setCompanyCalenderId(String companyCalenderId) {
    this.companyCalenderId = companyCalenderId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDateFrom() {
    return dateFrom;
  }

  public void setDateFrom(String dateFrom) {
    this.dateFrom = dateFrom;
  }

  public String getDateTo() {
    return dateTo;
  }

  public void setDateTo(String dateTo) {
    this.dateTo = dateTo;
  }

  public String getTotalHoliday() {
    return totalHoliday;
  }

  public void setTotalHoliday(String totalHoliday) {
    this.totalHoliday = totalHoliday;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getDeleteFlag() {
    return deleteFlag;
  }

  public void setDeleteFlag(String deleteFlag) {
    this.deleteFlag = deleteFlag;
  }

  @Override
  public String toString() {
    return "CompanyCalenderModel [companyCalenderId=" + companyCalenderId + ", "
      + "title=" + title + ", dateFrom=" + dateFrom + ", dateTo=" + dateTo + ", "
      + "totalHoliday=" + totalHoliday + ", type=" + type + ", comment=" + comment + "]";
  }
  
}
