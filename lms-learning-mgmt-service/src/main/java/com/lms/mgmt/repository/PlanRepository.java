package com.lms.mgmt.repository;

import com.lms.mgmt.entity.Category;
import com.lms.mgmt.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends JpaRepository<Plan,Integer> {

}
