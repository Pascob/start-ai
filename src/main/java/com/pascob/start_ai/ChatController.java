package com.pascob.start_ai;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.retry.NonTransientAiException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api")
public class ChatController {
    private final Logger log = LoggerFactory.getLogger(ChatController.class);

    private ChatClient chatClient;

    public ChatController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping("/chat")
    public String chat(String question) throws NonTransientAiException{
        log.info("Requet pour soumettre une question : {}", question);
        String content = chatClient.prompt().user(question).call().content();
        return content;
    }
}
