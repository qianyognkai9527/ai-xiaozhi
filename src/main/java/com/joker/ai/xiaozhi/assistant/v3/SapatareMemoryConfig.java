package com.joker.ai.xiaozhi.assistant.v3;


import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SapatareMemoryConfig {

    @Bean
    public ChatMemoryProvider chatMemoryProvider(){
        return memoryId -> {
            MessageWindowChatMemory messageWindowChatMemory = MessageWindowChatMemory.builder().maxMessages(20)
                    .id(memoryId)
                    .build();
            return messageWindowChatMemory;
        };
    }
}
