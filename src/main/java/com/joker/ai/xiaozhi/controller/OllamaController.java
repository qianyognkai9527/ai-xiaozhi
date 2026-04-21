package com.joker.ai.xiaozhi.controller;


import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ollama")
public class OllamaController {






    @Autowired
    private OllamaChatModel ollamaChatModel;
    @GetMapping("/chat")
    public String demo2() {
        return ollamaChatModel.chat("你是谁");
    }

}
