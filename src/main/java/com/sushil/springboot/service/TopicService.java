package com.sushil.springboot.service;

import java.util.List;

import com.sushil.springboot.beans.Topic;

public interface TopicService {
	
	public Topic getTopic(long topicId);
	
	public void addTopic(Topic topic);
	
	public void updateTopic(Topic topic);
	
	public void deleteTopic(long topic);
	
	public List<Topic> getAllTopics();
}
