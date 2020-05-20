package com.fuwenhao.controller;

import com.fuwenhao.config.MyAnnotation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;

/**
 * @author fwh
 * @email fuwenhao594@163.com
 * @date 2020/5/20 10:54 上午
 */
@RestController
@RequestMapping("annotation")
public class AnnotationController {
    @MyAnnotation(address = "西城土著", age = 18)
    private String userName;

    @GetMapping("sourceA")
    public String sourceA(HttpServletRequest request) {
        return "访问资源sourceA";
    }

    @GetMapping("sourceB")
    public String sourceB(HttpServletRequest request) {
        return "访问资源sourceB";
    }

    /**
     * 反射测试
     *
     * @param
     * @return java.lang.String
     * @author fwh [2020/5/20 && 11:02 上午]
     */
    @GetMapping("reflectTest")
    public String reflectTest() {
        final Class annotationControllerClass = AnnotationController.class;
        for (Field field : annotationControllerClass.getDeclaredFields()) {
            if (field.isAnnotationPresent(MyAnnotation.class)) {
                final MyAnnotation annotation = field.getAnnotation(MyAnnotation.class);
                final String name = field.getName();
                final String address = annotation.address();
                final int age = annotation.age();
                System.out.println(String.format("name：%s,address:%s,age:%s", name, address, age));
                return String.format("name：%s,address:%s,age:%s", name, address, age);
            }
        }
        return "没有找到字段";
    }
}
