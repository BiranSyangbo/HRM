package com.nepdroid.hrm.attendance.repository;

import com.nepdroid.hrm.attendance.model.LeaveModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveRepository extends JpaRepository<LeaveModel, String> {

}
