package com.shawood.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/apiv1")
public class IndexController {
    private final String INDEX_PAGE="index.html";

    // 处理根路径请求
    @GetMapping
    public String index(){
        return INDEX_PAGE;
    }

    // 处理带参数的请求
    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";  // 返回视图名称 (hello.html)
    }
}
