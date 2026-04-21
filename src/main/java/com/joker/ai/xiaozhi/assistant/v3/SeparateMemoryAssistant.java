package com.joker.ai.xiaozhi.assistant.v3;


import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;

/**
 * 记忆隔离智能体
 */

@AiService(wiringMode = AiServiceWiringMode.EXPLICIT,
chatModel = "openAiChatModel",
chatMemoryProvider = "chatMemoryProvider")
public interface SeparateMemoryAssistant {

    String startChat(@MemoryId Object Id,@UserMessage String question);

//    @SystemMessage("你是我的好朋友，请用东北话回答问题。今天是{{current_date}}")//系统消息提示词
    @SystemMessage(fromResource = "system-prompt.txt")//系统消息提示词
    String startPromptChat(@MemoryId Object Id,@UserMessage String question);
}
