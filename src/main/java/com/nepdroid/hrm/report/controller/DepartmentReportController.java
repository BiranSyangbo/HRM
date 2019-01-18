//package com.nepdroid.hrm.report.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.nepdroid.hrm.report.model.BranchReportModel;
//import com.nepdroid.hrm.report.model.DepartmentReportModel;
//import com.nepdroid.hrm.report.repository.BranchReportRepository;
//import com.nepdroid.hrm.report.repository.DepartmentReportRepository;
//
///**
//* This class program implements an application that simply performs 
//* reporting generation operations for Department Report Model.
//* @author  Bipin Shrestha
//* @version 1.0
//* @since   2018-11-31 
//*/
//
//@RestController
//public class DepartmentReportController {
//
//  @Autowired
//  private DepartmentReportRepository departmentReportRepository;
//  
//  /**
//   * This is a method to get the whole report of all Department details.
//   * @param pageable This is a parameter to getAllDepartment method.
//   * @return Page This returns response of whole report of all department details.
//   */
//  @GetMapping("/departmentReport")
//  public Page<DepartmentReportModel> getAllDepartment(Pageable pageable) {
//    return departmentReportRepository.findAll(pageable);
//  }
//
//  /**
//   * This is a method to get the report of a department by id.
//   * @param departmentId This is a parameter to getDepartmentByDepartmentId method.
//   * @param pageable This is a parameter to getDepartmentByDepartmentId method.
//   * @return Page This returns response of report of a branch by id.
//   */
//  @GetMapping("/branchReportByBranchId/{branchId}")
//  public Page<BranchReportModel> getBranchByBranchId(@PathVariable String branchId,
//      Pageable pageable) {
//    return branchReportRepository.findByBranchId(branchId, pageable);
//  }