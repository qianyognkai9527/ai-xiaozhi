package com.joker.ai.xiaozhi.controller;

import com.alibaba.cloud.ai.dashscope.image.DashScopeImageOptions;
import org.springframework.ai.image.ImageModel;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bailian")
public class BailianController {


    @Autowired
    private ImageModel imageModel;

    public static final String IMAGE_MODEL = "wan2.2-t2i-flash";
//    public static final String IMAGE_MODEL="wanx2.1-t2i-turbo";

    @GetMapping("/image")
    public String generate(@RequestParam(value = "prompt", defaultValue = "奇幻森林精灵：在一片弥漫着轻柔薄雾的\n" +
            "古老森林深处，阳光透过茂密枝叶洒下金色光斑。一位身材娇小、长着透明薄翼的精灵少女站在一朵硕大的蘑菇上。她\n" +
            "有着海藻般的绿色长发，发间点缀着蓝色的小花，皮肤泛着珍珠般的微光。身上穿着由翠绿树叶和白色藤蔓编织而成的\n" +
            "连衣裙，手中捧着一颗散发着柔和光芒的水晶球，周围环绕着五彩斑斓的蝴蝶，脚下是铺满苔藓的地面，蘑菇和蕨类植\n" +
            "物丛生，营造出神秘而梦幻的氛围。") String prompt) {
        DashScopeImageOptions dashScopeImageOptions = DashScopeImageOptions.builder()
                .withModel(IMAGE_MODEL).build();

        return imageModel.call(new ImagePrompt(prompt, dashScopeImageOptions))
                .getResult().getOutput().getUrl();
    }
}
