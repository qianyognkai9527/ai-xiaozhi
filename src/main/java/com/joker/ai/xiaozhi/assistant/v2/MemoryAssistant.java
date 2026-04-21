package com.joker.ai.xiaozhi.assistant.v2;


import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;

/**
 *  初级智能体
 */
@AiService(wiringMode = AiServiceWiringMode.EXPLICIT,
chatModel = "openAiChatModel",chatMemory = "chatMemory")
public interface MemoryAssistant {
    String startChat(String message);
}
