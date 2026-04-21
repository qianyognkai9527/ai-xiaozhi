package com.joker.ai.xiaozhi.assistant.v2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/memory")
public class MemoryController {


    @Autowired
    private MemoryAssistant memoryAssistant;
    @GetMapping("/chat")
    public String demo() {
        String string = memoryAssistant.startChat("我是张起灵");
        String string1 = memoryAssistant.startChat("你还知道我是谁吗");
        return string1+"=============="+string1;

    }
}
