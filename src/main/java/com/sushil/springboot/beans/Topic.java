package com.sushil.springboot.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TOPIC")
public class Topic implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "topicseq", sequenceName="TOPIC_SEQ",initialValue=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="topicseq")
	@Column(name="TOPIC_ID")
	private long topicId;
	@Column(name="TOPIC_NAME",unique=true)
	private String name;
	@Column(name="DESCRIPTION")
	private String description;
	@OneToMany(/*mappedBy="topic",*/cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.EAGER)
	private Set<Course> courses = new HashSet<Course>();
	
	public long getTopicId() {
		return topicId;
	}
	public void setTopicId(long topicId) {
		this.topicId = topicId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	@Override
	public String toString() {
		return "Topic [topicId=" + topicId + ", name=" + name + ", description=" + description 
				+ "]";
	}
	
	
}
