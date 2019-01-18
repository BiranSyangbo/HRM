package com.nepdroid.hrm.company.repository;

import com.nepdroid.hrm.company.model.RankModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RankRepository extends JpaRepository<RankModel, String> {

}
