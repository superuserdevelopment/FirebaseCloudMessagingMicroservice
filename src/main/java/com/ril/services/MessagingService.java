package com.ril.services;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.*;

@Service
public class MessagingService {

	public String sendNotificationSpecific(String title, String body, String registrationToken) {

		// See documentation on defining a message payload.
		// Set the title and body here
		Notification notification = Notification.builder().setTitle(title).setBody(body).build();
		// Build the actual message here
		Message message = Message.builder().setNotification(notification).setToken(registrationToken).build();

		try {
			// Send a message to the device corresponding to the provided
			// registration token.
			String response = FirebaseMessaging.getInstance().send(message);
			// Response is a message ID string.
			return ("Successfully sent message");
		} catch (Exception e) {
			return ("Message sending unsuccessful:\n" + e.toString());
		}
	}

	public String sendNotificationTopicwise(String title, String body, String topic) {
		Notification notification = Notification.builder().setTitle(title).setBody(body).build();
		// Build the actual message here
		Message message = Message.builder().setNotification(notification).setTopic(topic).build();

		try {
			// Send a message to the device corresponding to the provided
			// registration token.
			String response = FirebaseMessaging.getInstance().send(message);
			// Response is a message ID string.
			return ("Successfully sent message");
		} catch (Exception e) {
			System.out.println("Message sending unsuccessful:\n" + e.getMessage());
			return ("Message sending unsuccessful:\n" + e.toString());
		}
	}
	
	public String sendNotificationWithPayLoadSpecific(String title, String body, String registrationToken,
			Map<String, String> data) {
		Notification notification = Notification.builder().setTitle(title).setBody(body).build();
		// Build the actual message here
		Message.Builder messageBuilder = Message.builder().setNotification(notification).setToken(registrationToken);
		for (Map.Entry<String, String> entry : data.entrySet()) {
			//Mapping the data to the message
			messageBuilder.putData(entry.getKey(),entry.getValue());
		}
		Message message = messageBuilder.build();
		try {
			// Send a message to the device corresponding to the provided
			// registration token.
			String response = FirebaseMessaging.getInstance().send(message);
			// Response is a message ID string.
			return ("Successfully sent message");
		} catch (Exception e) {
			System.out.println("Message sending unsuccessful:\n" + e.getMessage());
			return ("Message sending unsuccessful:\n" + e.toString());
		}
	}
	
	public String sendNotificationWithPayLoadTopicwise(String title, String body, String topic,
			Map<String, String> data) {
		Notification notification = Notification.builder().setTitle(title).setBody(body).build();
		// Build the actual message here
		Message.Builder messageBuilder = Message.builder().setNotification(notification).setTopic(topic);
		for (Map.Entry<String, String> entry : data.entrySet()) {
			//System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			//Mapping the data to the message
			messageBuilder.putData(entry.getKey(),entry.getValue());
		}
		Message message = messageBuilder.build();
		try {
			String response = FirebaseMessaging.getInstance().send(message);
			// Response is a message ID string.
			return ("Successfully sent message");
		} catch (Exception e) {
			System.out.println("Message sending unsuccessful:\n" + e.getMessage());
			return ("Message sending unsuccessful:\n" + e.toString());
		}
	}
}
