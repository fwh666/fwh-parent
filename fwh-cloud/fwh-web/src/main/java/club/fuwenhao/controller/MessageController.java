package club.fuwenhao.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: fwh-parent
 * @description: 短信验证功能
 * @author: fwh
 * @date: 2021-05-18 14:27
 **/
@RestController
public class MessageController {

    @PostMapping("/messageCheck")
    public String messageCheck(@RequestParam("phone") String phone) {
        //手机号发短信
        //短信验证码校验
        //校验通过
        return null;
    }
}
