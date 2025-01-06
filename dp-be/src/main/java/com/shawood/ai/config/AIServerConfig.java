package com.shawood.ai.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * AIServer参数配置
 */
@Component
@Data
// 将这个类与前缀为AIServer的配置绑定
@ConfigurationProperties(prefix = "aiserver")
public class AIServerConfig {
    private String openaiapikey;
    private String baiduapikey;
}
