package com.joker.ai.xiaozhi.prompt.v2;

import com.joker.ai.xiaozhi.assistant.v4.PersisentSaperateMemoryAssistant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户提示词
 */
@RestController
@RequestMapping("/userPrompt")
public class UserPromptController {

    @Autowired
    private PersisentSaperateMemoryAssistant persisentSaperateMemoryAssistant;

    @GetMapping("/chat")
    public String demo(@RequestParam("message1") String message1,
                       @RequestParam("message2") String message2,
                       @RequestParam("message3") String message3,
                       @RequestParam("message4") String message4) {
        String string1 = persisentSaperateMemoryAssistant.startUserPromptChat(1, message1);
        String string2 = persisentSaperateMemoryAssistant.startUserPromptChat(1, message2);
        String string3 = persisentSaperateMemoryAssistant.startUserPromptChat(2, message3);
        String string4 = persisentSaperateMemoryAssistant.startUserPromptChat(2, message4);
        return string1 + "\n==============\n" + string2 + "\n==============\n" + string3 + "\n==============\n" + string4;
    }

    @GetMapping("/chat2")
    public String demo2() {
        return persisentSaperateMemoryAssistant.
                chat3(10, "你是谁，多大了，今天是几号","老亚瑟",19);
    }
}
