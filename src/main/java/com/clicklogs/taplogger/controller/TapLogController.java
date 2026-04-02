package com.clicklogs.taplogger.controller;

import com.clicklogs.taplogger.dto.TapLogRequest;
import com.clicklogs.taplogger.service.TapLogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/taps")
@CrossOrigin(origins = "*")
public class TapLogController {

    private final TapLogService tapLogService;

    public TapLogController(TapLogService tapLogService) {
        this.tapLogService = tapLogService;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> saveTap(@Valid @RequestBody TapLogRequest request) throws Exception {

        long durationMs = request.getEndTimestamp() - request.getStartTimestamp();

        String result = tapLogService.saveTap(request);

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "Saved to Firestore");
        response.put("status", result);
        response.put("sequenceNumber", request.getSequenceNumber());
        response.put("sessionId", request.getSessionId());
        response.put("devicePlatform", request.getDevicePlatform());
        response.put("interfaceType", request.getInterfaceType());
        response.put("durationMs", durationMs);

        return ResponseEntity.ok(response);
    }
}