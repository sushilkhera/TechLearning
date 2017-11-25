package com.sushil.springboot.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="COURSE")
public class Course implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "courseseq", sequenceName="COURSE_SEQ",initialValue=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="courseseq")
	private long courseId;
	@Column(name="COURSE_NAME",unique=true)
	private String name;
	@Column(name="DESCRIPTION")
	private String description;
	/*@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TOPIC_ID")
	private Topic topic;*/
	
	public long getCourseId() {
		return courseId;
	}
	public void setCourseId(long courseId) {
		this.courseId = courseId;
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
	/*public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}*/
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", name=" + name + ", description=" + description /*+ ", topic=" + topic*/
				+ "]";
	}
}
