package com.nepdroid.hrm.attendance.repository;

import com.nepdroid.hrm.attendance.model.WorkShiftModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkShiftRepository extends JpaRepository<WorkShiftModel, String> {

}
