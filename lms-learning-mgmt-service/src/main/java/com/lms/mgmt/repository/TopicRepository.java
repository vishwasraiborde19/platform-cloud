package com.lms.mgmt.repository;

import com.lms.mgmt.entity.Plan;
import com.lms.mgmt.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository<Topic,Integer> {

}
