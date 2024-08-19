package com.pascob.start_ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.retry.NonTransientAiException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/chat")
public class FinancialChatController {

    private ChatClient chatClient;

    public FinancialChatController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/finance")
    public String chat(String question) throws NonTransientAiException{
        String content = chatClient.prompt().user(question).call().content();
        return content;
    }
}
