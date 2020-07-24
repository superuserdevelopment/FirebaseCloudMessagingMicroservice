package com.ril.services;

import java.io.FileInputStream;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.*;
@Service
public class FirebaseService {
	@PostConstruct
	public void initialize() {
		try {
			FileInputStream serviceAccount = new FileInputStream("./serviceAccountKey.json");

			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(serviceAccount))
					.setDatabaseUrl("https://newsletter-a774d.firebaseio.com").build();

			FirebaseApp.initializeApp(options);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
}
