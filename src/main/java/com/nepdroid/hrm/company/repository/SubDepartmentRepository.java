package com.nepdroid.hrm.company.repository;

import com.nepdroid.hrm.company.model.SubDepartmentModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubDepartmentRepository extends JpaRepository<SubDepartmentModel, String> {

  public SubDepartmentModel findByDepartmentId(String departmentId);
}
