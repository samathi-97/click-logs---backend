package com.clicklogs.taplogger.service;

import com.clicklogs.taplogger.dto.TapLogRequest;
import com.clicklogs.taplogger.model.TapLog;
import com.google.cloud.firestore.Firestore;
import org.springframework.stereotype.Service;

@Service
public class TapLogService {

    private final Firestore firestore;

    public TapLogService(Firestore firestore) {
        this.firestore = firestore;
    }

    public String saveTap(TapLogRequest request) throws Exception {

        long duration = request.getEndTimestamp() - request.getStartTimestamp();

        TapLog tapLog = new TapLog(
                request.getSequenceNumber(),
                request.getStartTimestamp(),
                request.getEndTimestamp(),
                duration,
                request.getInterfaceType(),
                request.getSessionId(),
                request.getDevicePlatform(),
                System.currentTimeMillis()
        );

        firestore.collection("tap_logs").add(tapLog).get();

        return "saved";
    }
}