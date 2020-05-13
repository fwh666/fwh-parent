package com.fuwenhao.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author fwh
 * @email fuwenhao594@163.com
 * @date 2020/5/9 9:57 上午
 */
@RestController
@RequestMapping("web")
public class TestController {
    @GetMapping("hello")
    public String hello(HttpServletRequest request) {
        final String method = request.getMethod();
        return "方法："+method+",hello:" + request.getParameterMap().toString();
    }
}
