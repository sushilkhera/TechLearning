package com.sushil.springboot.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("topics")
public class TopicController {

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public String getTopic(@PathVariable("id") int topicId) {
		System.out.println("Received Topic id::"+topicId);
		return "Success";
	}
}
