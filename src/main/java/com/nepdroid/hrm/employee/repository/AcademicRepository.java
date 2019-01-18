package com.nepdroid.hrm.employee.repository;

import com.nepdroid.hrm.employee.model.AcademicModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AcademicRepository extends JpaRepository<AcademicModel, String> {

}
