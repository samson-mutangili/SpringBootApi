package com.samson.controllers.course;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//make the class a service by annotating @Service
@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
//
//	private List<Course> topics = new ArrayList<>( Arrays.asList(
//			new Course("spring", "spring framework", "spring framework description"),
//			new Course("java" ,"Core java", "Core java decription"),
//			new Course("javascript", "javascript", "javascript description")
//			));
	
	public List<Course> getAllCourses(String topicId){
//		return topics;
		
//		get all the topic in the DB and iterate, creating a new topic
		List<Course> topics = new ArrayList<>();
		
		courseRepository.findByTopicId(topicId).forEach(topics::add);
		
		return topics;
	}
	
	public Course getCourse(String id) {
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		
		return courseRepository.findOne(id);
	}

	public void addCourse(Course course) {
//		topics.add(topic);
		
		courseRepository.save(course);
	}

	public void updateCourse(Course course) {
		
		//loop through the topics list and update
//		for(int i=1; i<topics.size(); i++) {
//			Topic t = topics.get(i);
//			if(t.getId().equals(id)) {
//				topics.set(i, topic);
//				return;
//			}
//		}
		
		courseRepository.save(course);
		
	}

	public void deleteCourse(String id) {
		
//		topics.removeIf(t -> t.getId().equals(id));
		courseRepository.delete(id);
	}
}
