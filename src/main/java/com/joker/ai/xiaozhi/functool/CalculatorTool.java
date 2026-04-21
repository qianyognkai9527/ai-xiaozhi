package com.joker.ai.xiaozhi.functool;


import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import dev.langchain4j.agent.tool.ToolMemoryId;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class CalculatorTool {
    /**
     *
     * @param memoryId
     * @param a
     * @param b
     * @return
     */
    @Tool(name = "加法", value = "返回两个参数相加之和")
    public double sum(@ToolMemoryId Object memoryId,
                      @P(value = "a",required = true) double a,
                      @P(value = "b",required = true) double b) {

        log.info("调用加法算");
        return a + b;
    }

    /**
     *
     * @param id
     * @param x
     * @return
     */
    @Tool(name = "平方根", value = "返回给定参数的平方根")
    public double squareRoot(@ToolMemoryId Object id,
                             @P(value = "x",required = true) double x) {
        log.info("调用平方根运算");
        return Math.sqrt(x);
    }
}
