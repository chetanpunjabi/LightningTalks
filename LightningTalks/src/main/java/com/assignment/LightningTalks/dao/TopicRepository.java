package com.assignment.LightningTalks.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.LightningTalks.model.Topic;

@Repository("topicRepository")
public interface TopicRepository extends JpaRepository<Topic, Integer> {

}
