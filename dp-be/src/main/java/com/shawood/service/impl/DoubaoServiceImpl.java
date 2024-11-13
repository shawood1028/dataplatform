package com.shawood.service.impl;

import com.shawood.service.intf.AIService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DoubaoServiceImpl implements AIService {

    @Value("${aiservers.doubaoapikey}")
    private String apikey;

    private final RestTemplate restTemplate;

    public DoubaoServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String generateText(String prompt) {
        return "doubao resp 321";
    }
}
