package com.shawood.service;

import com.shawood.service.impl.OpenAIServiceImpl;
import com.shawood.service.intf.AIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AIServiceFactory {
    private final OpenAIServiceImpl openAIService;

    @Autowired
    public AIServiceFactory(OpenAIServiceImpl openAIService) {
        this.openAIService = openAIService;
    }

    public AIService createService(String platform) throws IllegalAccessException {
        switch (platform.toLowerCase()) {
            case "openai":
                return openAIService;
            default:
                throw new IllegalAccessException("Unsupported platform: " + platform);
        }
    }
}
