package club.fuwenhao;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * @author fwh
 * @email fuwenhao594@163.com
 * @date 2020/11/26 3:34 下午
 */
public class FwhConsumer {

    @RabbitListener(bindings = @QueueBinding(value = @Queue(),
            exchange = @Exchange(value = "user-rule-fwh-test", type = ExchangeTypes.FANOUT)))
    public void process(String msg) {
        System.out.println("msg:"+msg);
    }
}
