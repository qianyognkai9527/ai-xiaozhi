package com.joker.ai.xiaozhi.controller;


import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {


    @GetMapping("/chat")
    public String demo() {

        OpenAiChatModel model = OpenAiChatModel.builder()
                .baseUrl("http://langchain4j.dev/demo/openai/v1")
                .apiKey("demo")
                .modelName("gpt-4o-mini")
                .build();
        return model.chat("你是谁");
    }


    @Autowired
    private OpenAiChatModel openAiChatModel;
    @GetMapping("/chat2")
    public String demo2() {
        return openAiChatModel.chat("你是谁");
    }

//    @Autowired
//    private ChatLanguageModel chatLanguageModel;//自动注入2个ChatLanguageModel对象，此时不能启用注入ChatLanguageModel对象了
//    @GetMapping("/chat3")
//    public String demo3() {
//        return chatLanguageModel.chat("你是谁");
//    }
}
