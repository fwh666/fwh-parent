package club.fuwenhao.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author fwh
 * @email fuwenhao594@163.com
 * @date 2021/1/5 11:01 上午
 */
@RestController
public class TestController {
    @GetMapping("/test")
    public String test(HttpServletRequest request) {
        return "test:" + request.getServerName();
    }
    @GetMapping("/fwh")
    public String fwh(HttpServletRequest request) {
        return "fwh:" + request.getServerName();
    }
}
