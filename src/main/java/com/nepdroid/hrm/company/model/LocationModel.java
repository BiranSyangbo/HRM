package com.nepdroid.hrm.company.model;

import com.nepdroid.hrm.entity.AuditModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.hibernate.annotations.GenericGenerator;


/**
 * This is a model class for Company Branch Location
 * with its getter and setter functions. 
 *
 * @author  Bipin Shrestha
 * @version 1.0
 * @since   2019-01-06 
 */

@Entity
@Table(name = "location")
public class LocationModel extends AuditModel {

  /**
   * During serialization, java runtime associates a version number with each serializable class. 
   * This number called serialVersionUID, which is used during deserialization to verify that 
   * the sender and receiver of a serialized object have loaded classes for that object that are 
   * compatible with respect to serialization.
   */
  private static final long serialVersionUID = 4502259003584668343L;

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "LOCATION_ID")
  private String locationId;
  
  @Column(name = "BRANCH_ID")
  @NotNull
  private String branchId;

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

  
  public String getBranchId() {
    return branchId;
  }

  public void setBranchId(String branchId) {
    this.branchId = branchId;
  }

  @Override
  public String toString() {
    return "LocationModel [locationId=" + locationId + ", branchId=" + branchId + ","
      + "streetAddress=" + streetAddress + ", city=" + city + ", stateProvince="
      + stateProvince + ", country=" + country + ", region=" + region + "]";
  }
  
}
