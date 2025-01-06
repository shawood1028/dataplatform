package com.shawood.ai.service;

import com.shawood.ai.service.impl.DoubaoServiceImpl;
import com.shawood.ai.service.impl.OpenAIServiceImpl;
import com.shawood.ai.service.intf.AIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AIServiceFactory {
    private final OpenAIServiceImpl openAIService;
    private final DoubaoServiceImpl doubaoService;

    @Autowired
    public AIServiceFactory(OpenAIServiceImpl openAIService, DoubaoServiceImpl doubaoService) {
        this.openAIService = openAIService;
        this.doubaoService = doubaoService;
    }

    public AIService createService(String platform) throws IllegalAccessException {
        switch (platform.toLowerCase()) {
            case "openai":
                return openAIService;
            case "doubao":
                return doubaoService;
            default:
                throw new IllegalAccessException("Unsupported platform: " + platform);
        }
    }
}
