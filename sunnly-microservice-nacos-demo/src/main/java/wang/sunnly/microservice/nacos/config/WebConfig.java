package wang.sunnly.microservice.nacos.config;

import wang.sunnly.microservice.nacos.service.MySmsValidateCodeServicesImpl;
import wang.sunnly.microservice.nacos.validate.service.SmsValidateService;
import org.springframework.context.annotation.Configuration;

/**
 * @author Sunnly
 * @ClassName WebConfig
 * @Date 2019/6/10 0010 23:24
 **/
@Configuration
public class WebConfig {
//    @Bean
    public SmsValidateService smsValidateService(){
        return new MySmsValidateCodeServicesImpl();
    }
}
