package com.joker.ai.xiaozhi.functool;


import com.joker.ai.xiaozhi.assistant.v4.PersisentSaperateMemoryAssistant;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "功能工具")
@RequestMapping("/functionTool")
public class FunctionToolController {

    @Autowired
    private PersisentSaperateMemoryAssistant persisentSaperateMemoryAssistant;

    /**
     * 不会计算 大数字数学运算
     * @return
     */
    @GetMapping("/chat")
    public String demo() {
        String string = persisentSaperateMemoryAssistant.startChat(10, "1+1等于几，2349273932328的平方根是多少,你还不知道吗");
        return string;

    }


    @Autowired
    private ToolAssistant toolAssistant;

    /**
     * 用带工具的智能体 就能运算
     * @return
     */
    @GetMapping("/chat2")
    @Operation( summary= "用带工具的智能体 就能运算")
    public String demo2() {
        String string = toolAssistant.startChat(100, "134324253+132422324234等于几，23499823332423328的平方根是多少");
        return string;

    }
}
