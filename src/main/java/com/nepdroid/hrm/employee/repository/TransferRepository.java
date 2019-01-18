package com.nepdroid.hrm.employee.repository;

import com.nepdroid.hrm.employee.model.TransferModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRepository extends  JpaRepository<TransferModel, String> {

}
