package club.fuwenhao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author fwh
 * @email fuwenhao594@163.com
 * @date 2020/11/26 3:38 下午
 */
@SpringBootApplication
public class FwhRabbitmqApp {
    public static void main(String[] args) {
        SpringApplication.run(FwhRabbitmqApp.class, args);
    }
}
