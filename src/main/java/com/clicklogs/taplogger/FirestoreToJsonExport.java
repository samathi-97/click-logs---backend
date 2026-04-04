package com.clicklogs.taplogger;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FirestoreToJsonExport {

    public static void main(String[] args) throws Exception {

        if (FirebaseApp.getApps().isEmpty()) {
            InputStream serviceAccount =
                    FirestoreToJsonExport.class.getClassLoader()
                            .getResourceAsStream("firebase-service-account.json");

            if (serviceAccount == null) {
                throw new IllegalStateException("firebase-service-account.json not found in resources");
            }

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            FirebaseApp.initializeApp(options);
        }

        Firestore db = FirestoreClient.getFirestore();
        QuerySnapshot snapshot = db.collection("tap_logs").get().get();

        List<Map<String, Object>> records = new ArrayList<>();

        for (DocumentSnapshot doc : snapshot.getDocuments()) {
            Map<String, Object> data = doc.getData();
            if (data != null) {
                records.add(data);
            }
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter("tap_logs.json")) {
            gson.toJson(records, writer);
        }

        System.out.println("Exported " + records.size() + " records to tap_logs.json");
    }
}