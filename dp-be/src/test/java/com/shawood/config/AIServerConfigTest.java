package com.shawood.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AIServerConfigTest {
    @Autowired
    private AIServerConfig aiServerConfig;

    @Test
    public void test() {
        System.out.println("读取配置: name===" + aiServerConfig.getOpenaiapikey());
    }
}
