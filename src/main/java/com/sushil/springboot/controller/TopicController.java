package com.sushil.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sushil.springboot.beans.Topic;
import com.sushil.springboot.service.TopicService;

@RestController
@RequestMapping("topics")
public class TopicController {
	@Autowired
	@Qualifier("topicImpl")
	TopicService topicService;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public Topic getTopic(@PathVariable("id") long topicId) {
		printMessage("Rest Controller Topic id::"+topicId);
		return topicService.getTopic(topicId);
	}
	
	@RequestMapping(path="/add",method=RequestMethod.POST)
	public void addTopic(@RequestBody Topic topic) {
		printMessage("Inside addTopic()");
		printMessage("Received topic for add::"+topic.toString());
		topicService.addTopic(topic);
	}
	
	@RequestMapping(path="/all",method=RequestMethod.GET)
	public List<Topic> getAllTopics(){
		printMessage("Inside getAllTopics()");
		return topicService.getAllTopics();
	}
	
	@RequestMapping(path="/update/{id}",method=RequestMethod.PUT)
	public void updateTopic(@PathVariable("id") long topicId,@RequestBody Topic topic) {
		printMessage("Inside updateTopic()");
		topic.setTopicId(topicId);
		printMessage("Received topic for update::"+topic.toString());
		topicService.updateTopic(topic);
	}
	
	@RequestMapping(path="/delete/{id}",method=RequestMethod.DELETE)
	public void deleteTopic(@PathVariable("id") long topicId) {
		printMessage("Inside deleteTopic()");
		printMessage("Received topicId for delete::"+topicId);
		topicService.deleteTopic(topicId);
	}
	
	public void printMessage(String mgs) {
		System.out.println(mgs);
	}
}
