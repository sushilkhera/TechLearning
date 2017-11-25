package com.sushil.springboot.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sushil.springboot.beans.Topic;
import com.sushil.springboot.repo.TopicServiceRepo;
import com.sushil.springboot.service.TopicService;

@Service(value="topicImpl")
public class TopicServiceImpl implements TopicService{
	@Autowired
	TopicServiceRepo topicServiceRepo;
	
	public Topic getTopic(long topicId) {
		System.out.println("Service Layer::topicId="+topicId);
		Topic dbTopic = (Topic)topicServiceRepo.findByTopicId(topicId);
		if(dbTopic!=null) {
			System.out.println("dbTopic::"+dbTopic.toString());
			return dbTopic;
		}else {
			return null;
		}
	}

	@Override
	public void addTopic(Topic topic) {
		System.out.println("Service Layer::"+topic.toString());
		topicServiceRepo.save(topic);
	}

	@Override
	public void updateTopic(Topic topic) {
		topicServiceRepo.save(topic);
	}

	@Override
	public void deleteTopic(long topicId) {
		topicServiceRepo.delete(topicId);
	}

	@Override
	public List<Topic> getAllTopics() {
		List<Topic> topicsList = new ArrayList<Topic>();
		Iterable<Topic> topics= topicServiceRepo.findAll();
		topics.forEach(topic -> {
			topicsList.add(topic);
		});
		System.out.println("topicsList.size()="+topicsList.size());
		return topicsList;
	}
}
