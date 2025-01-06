package com.shawood.ai.controller;

import com.shawood.ai.service.AIServiceFactory;
import com.shawood.ai.service.intf.AIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai")
public class AIController {
    private final AIServiceFactory aiServiceFactory;

    @Autowired
    public AIController(AIServiceFactory aiServiceFactory){
        this.aiServiceFactory = aiServiceFactory;
    }

    @PostMapping("/generate")
    public String generateText(@RequestParam String platform, @RequestBody String prompt) throws IllegalAccessException {
        AIService aiService = aiServiceFactory.createService(platform);
        return aiService.generateText(prompt);
    }
}
