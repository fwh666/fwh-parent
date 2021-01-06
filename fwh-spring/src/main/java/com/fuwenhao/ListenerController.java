package com.fuwenhao;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author fwh
 * @email fuwenhao594@163.com
 * @date 2020/6/1 2:36 下午
 */
@Component
public class ListenerController implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("监听器："+event);
    }
}
