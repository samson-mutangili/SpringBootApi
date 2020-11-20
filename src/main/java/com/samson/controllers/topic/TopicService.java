package com.samson.controllers.topic;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//make the class a service by annotating @Service
@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;

	private List<Topic> topics = new ArrayList<>( Arrays.asList(
			new Topic("spring", "spring framework", "spring framework description"),
			new Topic("java" ,"Core java", "Core java decription"),
			new Topic("javascript", "javascript", "javascript description")
			));
	
	public List<Topic> getAllTopics(){
//		return topics;
		
//		get all the topic in the DB and iterate, creating a new topic
		List<Topic> topics = new ArrayList<>();
		
		topicRepository.findAll().forEach(topics::add);
		
		return topics;
	}
	
	public Topic getTopic(String id) {
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		
		return topicRepository.findOne(id);
	}

	public void addTopic(Topic topic) {
//		topics.add(topic);
		
		topicRepository.save(topic);
	}

	public void updateTopic(Topic topic, String id) {
		
		//loop through the topics list and update
//		for(int i=1; i<topics.size(); i++) {
//			Topic t = topics.get(i);
//			if(t.getId().equals(id)) {
//				topics.set(i, topic);
//				return;
//			}
//		}
		
		topicRepository.save(topic);
		
	}

	public void deleteTopic(String id) {
		
//		topics.removeIf(t -> t.getId().equals(id));
		topicRepository.delete(id);
	}
}
