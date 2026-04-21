package com.joker.ai.xiaozhi.assistant.v3;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/separateMemory")
public class SeparateMemoryController {


    @Autowired
    private SeparateMemoryAssistant separateMemoryAssistant;
    @GetMapping("/chat")
    public String demo() {
        String string = separateMemoryAssistant.startChat(1,"我是老亚瑟");
        String string1 = separateMemoryAssistant.startChat(1,"你还知道我是谁吗");

        String string2 = separateMemoryAssistant.startChat(2,"你还知道我是谁吗");
        return string+"=============="+string1+"============"+string2;
    }
}
