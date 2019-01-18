package com.nepdroid.hrm.employee.repository;

import com.nepdroid.hrm.employee.model.BankDetailModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankDetailRepository extends JpaRepository<BankDetailModel, String> {

}
