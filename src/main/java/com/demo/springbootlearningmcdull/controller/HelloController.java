package com.demo.springbootlearningmcdull.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 启动应用后在浏览器中打开 http://localhost:8080/say.html
 *
 * Controller是Spring MVC注解，表示此类负责处理Web请求
 */
@Controller
public class HelloController {

    //RequestMapping是Spring MVC注解，表示如果请求的路径匹配，被注解的方法将被调用
    //ResponseBody 表示返回的是文本而不是视图名称
    @RequestMapping("/say.html")
    public @ResponseBody
    String say(){
        return "Hello Mcdull";
    }

}
