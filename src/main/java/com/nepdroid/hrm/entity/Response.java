package com.nepdroid.hrm.entity;

import com.nepdroid.hrm.attendance.model.AttendanceModel;
import com.nepdroid.hrm.attendance.model.CompanyCalenderModel;
import com.nepdroid.hrm.attendance.model.LeaveModel;
import com.nepdroid.hrm.attendance.model.WorkShiftModel;
import com.nepdroid.hrm.company.model.BranchModel;
import com.nepdroid.hrm.company.model.DepartmentModel;
import com.nepdroid.hrm.company.model.LocationModel;
import com.nepdroid.hrm.company.model.RankModel;
import com.nepdroid.hrm.company.model.SubDepartmentModel;
import com.nepdroid.hrm.employee.model.AcademicModel;
import com.nepdroid.hrm.employee.model.BankDetailModel;
import com.nepdroid.hrm.employee.model.ContactModel;
import com.nepdroid.hrm.employee.model.EmployeeModel;
import com.nepdroid.hrm.employee.model.EmploymentHistoryModel;
import com.nepdroid.hrm.employee.model.PromotionModel;
import com.nepdroid.hrm.employee.model.TransferModel;

import java.util.Map;


public class Response {
  
  private boolean status;
  private Map<String, String> errorMessages;
  
  private EmployeeModel employeeModel;
  private DepartmentModel departmentModel;
  private SubDepartmentModel subDepartmentModel;
  private BranchModel branchModel;
  private LocationModel locationModel;
  private AttendanceModel attendanceModel;
  private WorkShiftModel workShiftModel;
  private LeaveModel leaveModel;
  private CompanyCalenderModel companyCalenderModel;
  private AcademicModel academicModel;
  private BankDetailModel bankDetailModel;
  private ContactModel contactModel;
  private EmploymentHistoryModel employmentHistoryModel;
  private RankModel rankModel;
  private PromotionModel promotionModel;
  private TransferModel transferModel;

  public boolean isStatus() {
    return status;
  }
  
  public void setStatus(boolean status) {
    this.status = status;
  }

  public Map<String, String> getErrorMessages() {
    return errorMessages;
  }

  public void setErrorMessages(Map<String, String> errorMessages) {
    this.errorMessages = errorMessages;
  }

  public EmployeeModel getEmployeeModel() {
    return employeeModel;
  }
  
  public void setEmployeeModel(EmployeeModel employeeModel) {
    this.employeeModel = employeeModel;
  }
  
  public DepartmentModel getDepartmentModel() {
    return departmentModel;
  }
  
  public void setDepartmentModel(DepartmentModel departmentModel) {
    this.departmentModel = departmentModel;
  }
  
  public LocationModel getLocationModel() {
    return locationModel;
  }
  
  public void setLocationModel(LocationModel locationModel) {
    this.locationModel = locationModel;
  }
  
  public AttendanceModel getAttendanceModel() {
    return attendanceModel;
  }
  
  public void setAttendanceModel(AttendanceModel attendanceModel) {
    this.attendanceModel = attendanceModel;
  }
  
  public WorkShiftModel getWorkShiftModel() {
    return workShiftModel;
  }
  
  public void setWorkShiftModel(WorkShiftModel workShiftModel) {
    this.workShiftModel = workShiftModel;
  }
  
  public LeaveModel getLeaveModel() {
    return leaveModel;
  }
  
  public void setLeaveModel(LeaveModel leaveModel) {
    this.leaveModel = leaveModel;
  }
  
  public CompanyCalenderModel getCompanyCalenderModel() {
    return companyCalenderModel;
  }
  
  public void setCompanyCalenderModel(CompanyCalenderModel companyCalenderModel) {
    this.companyCalenderModel = companyCalenderModel;
  }
  
  public AcademicModel getAcademicModel() {
    return academicModel;
  }
  
  public void setAcademicModel(AcademicModel academicModel) {
    this.academicModel = academicModel;
  }
  
  public BankDetailModel getBankDetailModel() {
    return bankDetailModel;
  }
  
  public void setBankDetailModel(BankDetailModel bankDetailModel) {
    this.bankDetailModel = bankDetailModel;
  }
  
  public ContactModel getContactModel() {
    return contactModel;
  }
  
  public void setContactModel(ContactModel contactModel) {
    this.contactModel = contactModel;
  }
  
  public EmploymentHistoryModel getEmploymentHistoryModel() {
    return employmentHistoryModel;
  }
  
  public void setEmploymentHistoryModel(EmploymentHistoryModel employmentHistoryModel) {
    this.employmentHistoryModel = employmentHistoryModel;
  }
  
  public RankModel getRankModel() {
    return rankModel;
  }
  
  public void setRankModel(RankModel rankModel) {
    this.rankModel = rankModel;
  }
  
  public PromotionModel getPromotionModel() {
    return promotionModel;
  }
  
  public void setPromotionModel(PromotionModel promotionModel) {
    this.promotionModel = promotionModel;
  }
  
  public TransferModel getTransferModel() {
    return transferModel;
  }
  
  public void setTransferModel(TransferModel transferModel) {
    this.transferModel = transferModel;
  }

  public BranchModel getBranchModel() {
    return branchModel;
  }

  public void setBranchModel(BranchModel branchModel) {
    this.branchModel = branchModel;
  }

  public SubDepartmentModel getSubDepartmentModel() {
    return subDepartmentModel;
  }

  public void setSubDepartmentModel(SubDepartmentModel subDepartmentModel) {
    this.subDepartmentModel = subDepartmentModel;
  }

}

/*
 * public class Response {
 * 
 * private boolean successfulRequest;
 * 
 * private Map<String, String> errorMap = new HashMap<>();
 * 
 * public boolean isSuccessfulRequest() { return successfulRequest; }
 * 
 * public void setSuccessfulRequest(boolean successfulRequest) {
 * this.successfulRequest = successfulRequest; }
 * 
 * public Map<String, String> getErrorMap() { return errorMap; }
 * 
 * public void setErrorMap(Map<String, String> errorMap) { this.errorMap =
 * errorMap; }
 * 
 * public void addMap(String code, String message) { errorMap.put(code,
 * message); } }
 */
