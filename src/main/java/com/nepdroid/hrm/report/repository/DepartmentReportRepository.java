package com.nepdroid.hrm.report.repository;

import com.nepdroid.hrm.report.model.DepartmentReportModel;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentReportRepository extends JpaRepository<DepartmentReportModel, String> {

  Page<DepartmentReportModel> findByDepartmentId(String departmentId, Pageable pageable);

}
