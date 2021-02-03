package club.fuwenhao.provider;

import club.fuwenhao.api.ProviderServiceInterface;
import club.fuwenhao.api.User;
import org.springframework.stereotype.Service;

/**
 * @author fwh
 * @email fuwenhao594@163.com
 * @date 2021/2/2 4:05 下午
 */
@Service
public class ProviderServiceImpl implements ProviderServiceInterface {
    @Override
    public User getUser() {
        return new User("fwh");
    }
}
