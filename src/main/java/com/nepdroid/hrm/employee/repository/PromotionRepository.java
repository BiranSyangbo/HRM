package com.nepdroid.hrm.employee.repository;

import com.nepdroid.hrm.employee.model.PromotionModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionRepository extends JpaRepository<PromotionModel, String> {

}
