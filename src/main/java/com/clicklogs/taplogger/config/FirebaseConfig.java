//package com.clicklogs.taplogger.config;
//
//import com.google.auth.oauth2.GoogleCredentials;
//import com.google.firebase.FirebaseApp;
//import com.google.firebase.FirebaseOptions;
//import com.google.cloud.firestore.Firestore;
//import com.google.firebase.cloud.FirestoreClient;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;

//import javax.annotation.PostConstruct;
//import java.io.InputStream;
//
//@Configuration
//public class FirebaseConfig {
//
//    @PostConstruct
//    public void init() throws Exception {
//
//        InputStream serviceAccount =
//                getClass().getClassLoader().getResourceAsStream("firebase-service-account.json");
//
//        FirebaseOptions options = FirebaseOptions.builder()
//                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//                .build();
//
//        if (FirebaseApp.getApps().isEmpty()) {
//            FirebaseApp.initializeApp(options);
//        }
//    }
//
//    @Bean
//    public Firestore firestore() {
//        return FirestoreClient.getFirestore();
//    }
//}
package com.clicklogs.taplogger.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Configuration
public class FirebaseConfig {

    @PostConstruct
    public void init() throws Exception {
        if (!FirebaseApp.getApps().isEmpty()) {
            return;
        }

        String firebaseJson = System.getenv("FIREBASE_SERVICE_ACCOUNT_JSON");
        InputStream serviceAccount;

        if (firebaseJson != null && !firebaseJson.isBlank()) {
            serviceAccount = new ByteArrayInputStream(
                    firebaseJson.getBytes(StandardCharsets.UTF_8)
            );
        } else {
            serviceAccount = getClass()
                    .getClassLoader()
                    .getResourceAsStream("firebase-service-account.json");
        }

        if (serviceAccount == null) {
            throw new IllegalStateException("Firebase credentials not found.");
        }

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        FirebaseApp.initializeApp(options);
    }

    @Bean
    public Firestore firestore() {
        return FirestoreClient.getFirestore();
    }
}