package com.nepdroid.hrm.employee.model;

import com.nepdroid.hrm.entity.AuditModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.GenericGenerator;

/**
 * This is a model class for Company Employee's Contact
 * with its getter and setter functions. 
 *
 * @author  Bipin Shrestha
 * @version 1.0
 * @since   2019-01-06 
 */
@Entity
@Table(name = "contact")
public class ContactModel extends AuditModel {

  /**
   * During serialization, java runtime associates a version number with each serializable class. 
   * This number called serialVersionUID, which is used during deserialization to verify that 
   * the sender and receiver of a serialized object have loaded classes for that object that are 
   * compatible with respect to serialization.
   */
  private static final long serialVersionUID = -9037471320470116322L;

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "CONTACT_ID")
  private String contactId;

  @Column(name = "CURRENT_ADDRESS")
  @NotNull
  private String currentAddress;

  @Column(name = "CURRENT_COUNTRY")
  @NotNull
  private String currentCountry;

  @Column(name = "CURRENT_DISTRICT")
  @NotNull
  private String currentDistrict;

  @Column(name = "PERMANENT_ADDRESS")
  @NotNull
  private String permanentAddress;

  @Column(name = "PERMANENT_COUNTRY")
  @NotNull
  private String permanentCountry;

  @Column(name = "PERMANENT_DISTRICT")
  @NotNull
  private String permanentDistrict;

  //must pass multiple numbers via front-end and bind to save here as one.
  @Column(name = "PHONE_MOBILE_NO") 
  @NotNull
  //d:digit only 9:length | :or 
  @Pattern(regexp = "\\d{10}|\\d{9} ", message = "Invalid phonenumber") 
  private String phoneMobileNo;

  @Column(name = "EMAIL", unique = true)
  @NotNull
  @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
      + "[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
      + "(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
      message = "Invalid Email")
  private String email;

  @Column(name = "EMERGENCY_CONTACT_NAME")
  @NotNull
  private String emergencyContactName;

  @Column(name = "EMERGENCY_CONTACT_NO")
  @NotNull
  @Pattern(regexp = "\\d{10}|\\d{9} ", message = "Invalid phonenumber")
  private String emergencyContactNo;

  @Column(name = "EMERGENCY_CONTACT_EMAIL", unique = true)
  @NotNull
  @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
      + "[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
      + "(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
      message = "Invalid Email")
  private String emergencyContactEmail;

  @Column(name = "DELETE_FLAG", nullable = true)
  private String deleteFlag;
  
  @Column(name = "EMPLOYEE_ID")
  @NotNull
  private String employeeId;

  public String getContactId() {
    return contactId;
  }

  public void setContactId(String contactId) {
    this.contactId = contactId;
  }

  public String getCurrentAddress() {
    return currentAddress;
  }

  public void setCurrentAddress(String currentAddress) {
    this.currentAddress = currentAddress;
  }

  public String getCurrentCountry() {
    return currentCountry;
  }

  public void setCurrentCountry(String currentCountry) {
    this.currentCountry = currentCountry;
  }

  public String getCurrentDistrict() {
    return currentDistrict;
  }

  public void setCurrentDistrict(String currentDistrict) {
    this.currentDistrict = currentDistrict;
  }

  public String getPermanentAddress() {
    return permanentAddress;
  }

  public void setPermanentAddress(String permanentAddress) {
    this.permanentAddress = permanentAddress;
  }

  public String getPermanentCountry() {
    return permanentCountry;
  }

  public void setPermanentCountry(String permanentCountry) {
    this.permanentCountry = permanentCountry;
  }

  public String getPermanentDistrict() {
    return permanentDistrict;
  }

  public void setPermanentDistrict(String permanentDistrict) {
    this.permanentDistrict = permanentDistrict;
  }

  public String getPhoneMobileNo() {
    return phoneMobileNo;
  }

  public void setPhoneMobileNo(String phoneMobileNo) {
    this.phoneMobileNo = phoneMobileNo;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEmergencyContactName() {
    return emergencyContactName;
  }

  public void setEmergencyContactName(String emergencyContactName) {
    this.emergencyContactName = emergencyContactName;
  }

  public String getEmergencyContactNo() {
    return emergencyContactNo;
  }

  public void setEmergencyContactNo(String emergencyContactNo) {
    this.emergencyContactNo = emergencyContactNo;
  }

  public String getEmergencyContactEmail() {
    return emergencyContactEmail;
  }

  public void setEmergencyContactEmail(String emergencyContactEmail) {
    this.emergencyContactEmail = emergencyContactEmail;
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
    return "ContactModel [contactId=" + contactId + ", currentAddress=" + currentAddress + ","
      + "currentCountry=" + currentCountry + ", currentDistrict=" + currentDistrict + ","
      + "permanentAddress=" + permanentAddress + ", permanentCountry=" + permanentCountry + ","
      + "permanentDistrict=" + permanentDistrict + ", phoneMobileNo=" + phoneMobileNo + ", email="
      + email + ", emergencyContactName=" + emergencyContactName + ", emergencyContactNo="
      + emergencyContactNo + ", emergencyContactEmail=" + emergencyContactEmail
      + ", employeeId=" + employeeId + "]";
  } 
   
}


/*@Pattern.List({
    @Pattern(regexp = "(?=.*[0-9])", message = "Password must contain one digit."),
    @Pattern(regexp = "(?=.*[a-z])", message = "Password must contain one lowercase letter."),
    @Pattern(regexp = "(?=.*[A-Z])", message = "Password must contain one uppercase letter."),
    @Pattern(regexp = "(?=\\S+$)", message = "Password must contain no whitespace.")
})
private String password;*/
