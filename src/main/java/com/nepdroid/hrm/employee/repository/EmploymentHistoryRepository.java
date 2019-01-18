package com.nepdroid.hrm.employee.repository;

import com.nepdroid.hrm.employee.model.EmploymentHistoryModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmploymentHistoryRepository extends JpaRepository<EmploymentHistoryModel, String> {

}
