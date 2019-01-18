package com.nepdroid.hrm.company.repository;

import com.nepdroid.hrm.company.model.BranchModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends JpaRepository<BranchModel, String> {

}
