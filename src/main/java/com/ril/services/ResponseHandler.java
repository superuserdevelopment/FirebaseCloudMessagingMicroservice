package com.ril.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResponseHandler {
	
	@RequestMapping("/Test/UZUMYMW")
	public String test() {
		MessagingService fcm = new MessagingService();
		//fcm.sendMessage();
		Map<String,String> data = new HashMap<String, String>();
		data.put("data1", "value1");
		data.put("data2", "value2");
		data.put("data3", "value3");
		data.put("data4", "value4");
		String registrationToken = "fAB2ZwHGdFw:APA91bF95XYGF6aZ53QBbvQhUu3bgEqP6wu_1uxgj2aauwDLzGjn5FKOd-hfBcYu8m4utmGhptIkm6O2jUkVsLo4IFPnqsnKvu0XN6KWuSxB7ghZ_5tnIfTzvFbrhkKp4grJDOBWHv_l";
		return fcm.sendNotificationWithPayLoadSpecific("title", "body", registrationToken, data);
		//fcm.sendNotificationTopicwise("Topicwise Notification", "Topic: General", "general");
	}
	
	@RequestMapping("/token/{registrationToken}/title={title}+body={body}")
	public String sendToToken(@PathVariable("registrationToken") final String registrationToken, @PathVariable("title") final String title, @PathVariable("body") final String body){
		MessagingService fcm = new MessagingService();
		return fcm.sendNotificationSpecific(title, body, registrationToken);
	}
	@RequestMapping("/topic/{topicName}/title={title}+body={body}")
	public String sendToTopic(@PathVariable("topicName") final String topicName, @PathVariable("title") final String title, @PathVariable("body") final String body){
		MessagingService fcm = new MessagingService();
		return fcm.sendNotificationTopicwise(title, body, topicName);
	}
}
