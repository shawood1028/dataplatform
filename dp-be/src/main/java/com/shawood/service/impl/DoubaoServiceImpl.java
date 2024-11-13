package com.shawood.service.impl;

import com.shawood.service.intf.AIService;
import org.springframework.beans.factory.annotation.Value;

public class DoubaoServiceImpl implements AIService {

    @Value("${aiservers.doubaoapikey}")
    @Override
    public String generateText(String prompt) {
        return "";
    }
}
