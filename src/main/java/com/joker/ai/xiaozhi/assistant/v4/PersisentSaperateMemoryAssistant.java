package com.joker.ai.xiaozhi.assistant.v4;


import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;

/**
 * 持久化分离记忆 智能体
 */

@AiService(wiringMode = AiServiceWiringMode.EXPLICIT,
        chatModel = "openAiChatModel",
        chatMemoryProvider = "chatMemoryProviderV2")
public interface PersisentSaperateMemoryAssistant {
    /**
     * 聊天
     *
     * @param userId
     * @param message
     * @return
     */
    String startChat(@MemoryId Integer userId, @UserMessage String message);

    /**
     * 用户提示词
     *
     * @param Id
     * @param question
     * @return
     */
    //    @SystemMessage("你是我的好朋友，请用东北话回答问题。今天是{{current_date}}")//系统消息提示词
    @SystemMessage(fromResource = "system-prompt.txt")
//系统消息提示词
    String startPromptChat(@MemoryId Object Id, @UserMessage String question);

    /**
     * 用户提示词
     * @param memoryId
     * @param question
     * @return
     */
    @UserMessage("你是我的好朋友，请用上海话回答问题，并且添加一些表情符号。 {{it}}")
    String startUserPromptChat(@MemoryId Object memoryId,@V("it") String question);

    /**
     * @SystemMessage和@V同时使用
     *
     * @param memoryId 聊天记忆Id
     * @param userMessage 用户message
     * @param username 参数1
     * @param age 参数2
     * @return
     */
    @SystemMessage(fromResource = "system-prompt2.txt")
    String chat3(
            @MemoryId int memoryId,
            @UserMessage String userMessage,
            @V("username") String username,
            @V("age") int age
    );
}
