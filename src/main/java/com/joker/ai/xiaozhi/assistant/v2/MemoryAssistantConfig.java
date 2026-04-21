package com.joker.ai.xiaozhi.assistant.v2;


import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MemoryAssistantConfig {

    @Bean
    public ChatMemory chatMemory(){
        return MessageWindowChatMemory.withMaxMessages(20);
    }
}
