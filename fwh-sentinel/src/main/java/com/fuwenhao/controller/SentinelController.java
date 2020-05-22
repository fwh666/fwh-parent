package com.fuwenhao.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalTime;

/**
 * @author fwh
 * @email fuwenhao594@163.com
 * @date 2020/5/22 4:42 下午
 */
@RestController
@RequestMapping("sentinel")
public class SentinelController {

    @GetMapping("sourceA")
    public String sourceA() {
        System.out.println("时间: " + LocalTime.now());
        return "访问资源：sourceA";
    }

    @GetMapping("sourceB")
    public void sourceB() throws InterruptedException {
        RestTemplate restTemplate = new RestTemplate();
        for (int i = 0; i < 100; i++) {
            final ResponseEntity<String> forEntity = restTemplate.getForEntity("http://127.0.0.1:8185/sentinel/sourceA", String.class);
//            Thread.sleep(1000);
            System.out.println(forEntity.getBody() + i + " 次");
        }
    }
}
