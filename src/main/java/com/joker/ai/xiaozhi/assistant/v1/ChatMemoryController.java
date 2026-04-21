package com.joker.ai.xiaozhi.assistant.v1;


import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/chatMemory")
public class ChatMemoryController {

    @Autowired
    private Assistant assistant;

    @GetMapping("/chat")
    public String demo() {
        String chat = assistant.chat("我是joker");
        String chat1 = assistant.chat("你还知道我是谁吗");
        return chat+"/n 第二次回答"+chat1;


    }

    @Autowired
    private OpenAiChatModel openAiChatModel;

    /**
     * 可以记忆，但是聊天记忆多的话就很吃力
     * Arrays.asList(userMessage1, aiMessage1。。。。。。
     * @return
     */
    @GetMapping("/chat2")
    public String demo2() {
        UserMessage userMessage1 = new UserMessage("你好，我是joker");
        ChatResponse chatResponse1 = openAiChatModel.chat(userMessage1);
        AiMessage aiMessage1= chatResponse1.aiMessage();
        System.out.println(aiMessage1.text());
        UserMessage userMessage2 = new UserMessage("你还知道我是谁吗");
        ChatResponse chat = openAiChatModel.chat(Arrays.asList(userMessage1, aiMessage1, userMessage2));
        System.out.println("=============");
        System.out.println(chat.aiMessage().text());
        return chat.aiMessage().text();

    }

    /**
     * 可以记忆，存储在内存里容易丢失，而且又maxMessage限制
     * @return
     */
    @GetMapping("/chat3")
    public String demo3() {

        MessageWindowChatMemory chatMemory = MessageWindowChatMemory.withMaxMessages(20);
        Assistant assistant = AiServices.builder(Assistant.class)
                .chatModel(openAiChatModel)
                .chatMemory(chatMemory)
                .build();
        String chat = assistant.chat("我是joker");
        String chat1 = assistant.chat("你还知道我是谁吗");
        return chat+"==================="+chat1;
    }
}
