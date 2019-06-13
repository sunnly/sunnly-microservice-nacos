package wang.sunnly.microservice.nacos.admin.consumer.service.impl;

import wang.sunnly.microservice.nacos.admin.consumer.service.UserService;
import org.springframework.stereotype.Component;

/**
 * @author Sunnly
 * @ClassName UserServiceFallback
 * @Date 2019/5/31 0031 21:57
 **/
@Component
public class UserServiceFallback implements UserService {
    @Override
    public String get(String id) {
        return "UserService FallBack";
    }
}
