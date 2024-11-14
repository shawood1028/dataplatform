package com.shawood.service.impl;

import com.shawood.service.intf.AIService;
import com.volcengine.ark.runtime.exception.ArkHttpException;
import com.volcengine.ark.runtime.model.completion.chat.ChatCompletionRequest;
import com.volcengine.ark.runtime.model.completion.chat.ChatMessage;
import com.volcengine.ark.runtime.model.completion.chat.ChatMessageRole;
import com.volcengine.ark.runtime.service.ArkService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

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
        ArkService arkService = ArkService.builder()
                .apiKey(apikey)
                .baseUrl("https://ark.cn-beijing.volces.com/api/v3/")
                .timeout(Duration.ofSeconds(20))
                .retryTimes(2)
                .build();
        System.out.println("\n----- streaming request -----");
        final List<ChatMessage> streamMessages = new ArrayList<>();
        final ChatMessage streamSystemMessage = ChatMessage.builder().role(ChatMessageRole.SYSTEM).content("你是豆包，是由字节跳动开发的 AI 人工智能助手").build();
        final ChatMessage streamUserMessage = ChatMessage.builder().role(ChatMessageRole.USER).content("常见的十字花科植物有哪些？").build();
        streamMessages.add(streamSystemMessage);
        streamMessages.add(streamUserMessage);

        ChatCompletionRequest streamChatCompletionRequest = ChatCompletionRequest.builder()
                .model("ep-20241114145158-sdfrh")
                .messages(streamMessages)
                .build();

        try {
            arkService.streamChatCompletion(streamChatCompletionRequest)
                    .doOnError(Throwable::printStackTrace)
                    .blockingForEach(
                            choice -> {
                                if (choice.getChoices().size() > 0) {
                                    System.out.print(choice.getChoices().get(0).getMessage().getContent());
                                }
                            }
                    );
        } catch (ArkHttpException e) {
            System.out.println(e.toString());
        }

        // shutdown service
        arkService.shutdownExecutor();
        return "doubao resp 321";
    }
}
