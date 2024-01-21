package com.roche.doselect2.service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

@Service
public class StaticsService {
	
	private final ConcurrentHashMap<String, AtomicInteger> requestCount = new ConcurrentHashMap<>();

    public void updateStatistics(int int1, int int2, int limit, String str1, String str2) {
        String key = int1 + "-" + int2 + "-" + limit + "-" + str1 + "-" + str2;
        requestCount.computeIfAbsent(key, k -> new AtomicInteger()).incrementAndGet();
    }

    public Map<String, Object> getStatistics() {
        Map<String, Object> result = new HashMap<>();
        Map.Entry<String, AtomicInteger> mostUsedRequest = findMostUsedRequest();
        
        if (mostUsedRequest != null) {
            result.put("mostUsedRequest", mostUsedRequest.getKey());
            result.put("hits", mostUsedRequest.getValue().get());
        } else {
            result.put("mostUsedRequest", "No requests yet.");
            result.put("hits", 0);
        }

        return result;
    }
    
    private Map.Entry<String, AtomicInteger> findMostUsedRequest() {
        return requestCount.entrySet().stream()
                .max(Map.Entry.comparingByValue((a, b) -> Integer.compare(a.get(), b.get())))
                .orElse(null);
    }


}
