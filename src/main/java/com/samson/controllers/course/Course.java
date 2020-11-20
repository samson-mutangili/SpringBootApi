package com.samson.controllers.course;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.samson.controllers.topic.Topic;

@Entity //makes a table whose name corresponds to the name of the class
public class Course {
	
	@Id //makes this attribute a primary key in the table
	private String id;
	private String name;
	private String description;
	
	//tie a course to a particular topic
	@ManyToOne
	private Topic topic;
	
	
	

	public Course() {
		
	}
	
	public Course(String id, String name, String description, String topicId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.topic = new Topic(topicId, "", "");
	}
	
	
	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	
	

}
