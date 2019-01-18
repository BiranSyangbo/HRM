package com.nepdroid.hrm.company.repository;

import com.nepdroid.hrm.company.model.LocationModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<LocationModel, String> {

  public LocationModel findByBranchId(String branchId);
}
