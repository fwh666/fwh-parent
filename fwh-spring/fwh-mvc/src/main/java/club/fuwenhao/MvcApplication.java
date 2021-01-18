package club.fuwenhao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author fwh
 * @email fuwenhao594@163.com
 * @date 2021/1/18 7:20 下午
 */
@SpringBootApplication
public class MvcApplication {
    public static void main(String[] args) {
        SpringApplication.run(MvcApplication.class, args);
        System.out.println("MvcApplication is start.");
    }
}
