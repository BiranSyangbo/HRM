package com.nepdroid.hrm.employee.repository;

import com.nepdroid.hrm.employee.model.EmployeeModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel, String> {

}
