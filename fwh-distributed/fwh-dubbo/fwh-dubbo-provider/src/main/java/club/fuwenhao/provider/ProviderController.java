package club.fuwenhao.provider;

import club.fuwenhao.api.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fwh
 * @email fuwenhao594@163.com
 * @date 2021/2/2 4:00 下午
 */
@RestController
@RequestMapping("provider")
public class ProviderController {
    @Autowired
    private ProviderServiceImpl providerService;

    @RequestMapping(value = "service")
    public User test() {
        return providerService.getUser();
    }
}
