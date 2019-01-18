package com.nepdroid.hrm.report.repository;

import com.nepdroid.hrm.report.model.BranchReportModel;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchReportRepository extends JpaRepository<BranchReportModel, String> {

  Page<BranchReportModel> findByBranchId(String branchId, Pageable pageable);
  
  //Page<BranchReportModel> findByLocationId(String locationId, Pageable pageable);
  
}
