package com.joker.ai.xiaozhi.assistant.v4;


import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SaperateMemoryV2Config {

    @Autowired
    private MongoChatMemoryStore mongoChatMemoryStore;

    @Bean("chatMemoryProviderV2")
    public ChatMemoryProvider chatMemoryProvider() {
        return new ChatMemoryProvider() {

            @Override
            public ChatMemory get(Object memoryId) {
                return MessageWindowChatMemory.builder()
                        .maxMessages(20)
                        .id(memoryId)
                        .chatMemoryStore(mongoChatMemoryStore)
                        .build();
            }
        };
    }
}
