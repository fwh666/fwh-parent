package club.fuwenhao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author fwh
 * @email fuwenhao594@163.com
 * @date 2021/2/3 2:17 下午
 */
@SpringBootApplication
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class,args);
        System.out.println("ConsumerApplication is start");
    }
}
