package com.nepdroid.hrm.report.controller;

import com.nepdroid.hrm.report.model.BranchReportModel;
import com.nepdroid.hrm.report.repository.BranchReportRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


/**
* This class program implements an application that simply performs 
* reporting generation operations for Branch Report Model.
* @author  Bipin Shrestha
* @version 1.0
* @since   2018-11-31 
*/

@RestController
public class BranchReportController {

  @Autowired
  private BranchReportRepository branchReportRepository;
  
  /**
   * This is a method to get the whole report of all branch details.
   * @param pageable This is a parameter to getAllBranch method.
   * @return Page This returns response of whole report of all branch details.
   */
  @GetMapping("/branchReport")
  public Page<BranchReportModel> getAllBranch(Pageable pageable) {
    return branchReportRepository.findAll(pageable);
  }

  /**
   * This is a method to get the report of a branch by id.
   * @param branchId This is a parameter to getBranchByBranchId method.
   * @param pageable This is a parameter to getBranchByBranchId method.
   * @return Page This returns response of report of a branch by id.
   */
  @GetMapping("/branchReportByBranchId/{branchId}")
  public Page<BranchReportModel> getBranchByBranchId(@PathVariable String branchId,
      Pageable pageable) {
    return branchReportRepository.findByBranchId(branchId, pageable);
  }
  
  
  /**
   * This is a method to get the report of a branch by id.
   * @param branchId This is a parameter to getBranchByBranchId method.
   * @param pageable This is a parameter to getBranchByBranchId method.
   * @return Page This returns response of report of a branch by id.
   */
  /*
  @GetMapping("/branchReportByLocationId/{locationId}")
  public Page<BranchReportModel> getBranchByLocationId(@PathVariable String locationId,
      Pageable pageable) {
    return branchReportRepository.findByLocationId(locationId, pageable);
  }
*/
}
