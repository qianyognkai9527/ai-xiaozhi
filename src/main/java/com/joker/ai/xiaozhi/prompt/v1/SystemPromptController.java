package com.joker.ai.xiaozhi.prompt.v1;


import com.joker.ai.xiaozhi.assistant.v3.SeparateMemoryAssistant;
import com.joker.ai.xiaozhi.assistant.v4.PersisentSaperateMemoryAssistant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *      系统提示词
 */
@RestController
@RequestMapping("/promptDemo")
public class SystemPromptController {

    @Autowired
    private PersisentSaperateMemoryAssistant separateMemoryAssistant;
    @GetMapping("/chat")
    public String demo() {
        return separateMemoryAssistant.startPromptChat(2,"你真不记得我了吧，我叫小日");
    }

    @GetMapping("/chat2")
    public String demo2() {
        return separateMemoryAssistant.startPromptChat(3,"今天是几号啊");
    }

    @GetMapping("/chat3")
    public String demo3() {
        return separateMemoryAssistant.startPromptChat(3,"看来你不记得我了，都不知道我的名字");
    }
}
