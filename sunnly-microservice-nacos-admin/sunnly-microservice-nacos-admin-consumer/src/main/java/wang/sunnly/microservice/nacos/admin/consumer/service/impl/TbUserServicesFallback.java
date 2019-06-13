package wang.sunnly.microservice.nacos.admin.consumer.service.impl;

import wang.sunnly.microservice.nacos.admin.consumer.service.TbUserService;
import org.springframework.stereotype.Component;

/**
 * @author Sunnly
 * @ClassName TbUserServicesFallback
 * @Date 2019/5/31 0031 23:09
 **/
@Component
public class TbUserServicesFallback implements TbUserService {

    @Override
    public String getUserById(String id) {
        return "User error ";
    }
}
