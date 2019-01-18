package com.nepdroid.hrm.report.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nepdroid.hrm.entity.AuditModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * This is a model class for Location Report Model
 * with its getter and setter functions. 
 *
 * @author  Bipin Shrestha
 * @version 1.0
 * @since   2019-01-06 
 */

@Entity
@Table(name = "location")
public class LocationReportModel extends AuditModel {

  /**
   *  This is a serial UID version number.
   */
  private static final long serialVersionUID = -3911737469028101729L;

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "LOCATION_ID")
  private String locationId;
  
  @OneToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "BRANCH_ID", nullable = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JsonIgnore
  private BranchReportModel branchReportModel;

  @Column(name = "STREET_ADDRESS")
  @NotNull
  private String streetAddress;

  @Column(name = "CITY", nullable = false)
  @NotNull
  private String city;

  @Column(name = "STATE_PROVINCE")
  @NotNull
  private String stateProvince;

  @Column(name = "COUNTRY")
  @NotNull
  private String country;

  @Column(name = "REGION")
  @NotNull
  private String region;
  
  @Column(name = "DELETE_FLAG", nullable = true)
  @Null
  private String deleteFlag;

  public String getLocationId() {
    return locationId;
  }

  public void setLocationId(String locationId) {
    this.locationId = locationId;
  }

  public String getStreetAddress() {
    return streetAddress;
  }

  public void setStreetAddress(String streetAddress) {
    this.streetAddress = streetAddress;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getStateProvince() {
    return stateProvince;
  }

  public void setStateProvince(String stateProvince) {
    this.stateProvince = stateProvince;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public String getDeleteFlag() {
    return deleteFlag;
  }

  public void setDeleteFlag(String deleteFlag) {
    this.deleteFlag = deleteFlag;
  }

  public BranchReportModel getBranchReportModel() {
    return branchReportModel;
  }

  public void setBranchReportModel(BranchReportModel branchReportModel) {
    this.branchReportModel = branchReportModel;
  }

  @Override
  public String toString() {
    return "LocationReportModel [locationId=" + locationId + ", branchReportModel=" 
      + branchReportModel + ", streetAddress=" + streetAddress + ", city=" + city + ","
      + "stateProvince=" + stateProvince + ", country=" + country + ", region=" + region + "]";
  }
}
