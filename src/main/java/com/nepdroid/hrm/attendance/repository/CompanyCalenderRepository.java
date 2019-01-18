package com.nepdroid.hrm.attendance.repository;

import com.nepdroid.hrm.attendance.model.CompanyCalenderModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyCalenderRepository extends JpaRepository<CompanyCalenderModel, String> {

}
