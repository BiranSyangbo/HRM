package com.nepdroid.hrm.company.repository;

import com.nepdroid.hrm.company.model.DepartmentModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentModel, String> {

}
