package club.fuwenhao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author fwh
 * @email fuwenhao594@163.com
 * @date 2021/2/2 3:40 下午
 */
@SpringBootApplication
public class ProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
        System.out.println("ProviderApplication is start");
    }
}
