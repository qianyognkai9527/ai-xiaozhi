package com.joker.ai.xiaozhi.assistant.v1;


import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aiService")
public class AiAssistaneController {

    @Autowired
    private OpenAiChatModel dashScopeChatModel;

    @GetMapping("/chat1")
    public String chat(@RequestParam(value = "question",defaultValue = "你是谁") String question) {
        Assistant assistant = AiServices.create(Assistant.class, dashScopeChatModel);
        String chat = assistant.chat(question);
        return chat;
    }

    @Autowired
    private Assistant assistant;
    @GetMapping("/chat2")
    public String chat2(@RequestParam(value = "question",defaultValue = "你是谁") String question) {
        String chat = assistant.chat(question);
        return chat;
    }

}
