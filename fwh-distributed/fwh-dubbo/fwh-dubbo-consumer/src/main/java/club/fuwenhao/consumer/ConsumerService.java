package club.fuwenhao.consumer;

import club.fuwenhao.api.ProviderServiceInterface;
import club.fuwenhao.api.User;
import com.alibaba.fastjson.JSONObject;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @Reference
    private ProviderServiceInterface providerService;

    public String test() {
        final User user1 = providerService.getUser();
        System.out.println("fwh-dubbo-consumer:"+user1);

        String result = HttpClient.get("http://localhost:38081/provider/service");
        User user = JSONObject.parseObject(result, User.class);
        return user.getUsername();
    }
}
