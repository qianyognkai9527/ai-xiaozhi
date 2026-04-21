package com.joker.ai.xiaozhi.assistant.v4;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persisentSaperateMemory")
public class PersisentSaperateMemoryController {

    @Autowired
    private PersisentSaperateMemoryAssistant persisentSaperateMemoryAssistant;
    @RequestMapping("/chat")
    public String demo(@RequestParam("message1") String message1,
                       @RequestParam("message2") String message2,
                       @RequestParam("message3") String message3,
                       @RequestParam("message4") String message4) {
        String string1 = persisentSaperateMemoryAssistant.startChat(1, message1);
        String string2 = persisentSaperateMemoryAssistant.startChat(1, message2);
        String string3 = persisentSaperateMemoryAssistant.startChat(2, message3);
        String string4 = persisentSaperateMemoryAssistant.startChat(2, message4);
        return string1+"\n==============\n"+string2+"\n==============\n"+string3+"\n==============\n"+string4;
    }
}
