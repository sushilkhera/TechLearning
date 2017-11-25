package com.sushil.springboot.repo;

import org.springframework.data.repository.CrudRepository;

import com.sushil.springboot.beans.Topic;

public interface TopicServiceRepo extends CrudRepository<Topic, Long>{
	
	public Topic findByTopicId(long topicID);
}
