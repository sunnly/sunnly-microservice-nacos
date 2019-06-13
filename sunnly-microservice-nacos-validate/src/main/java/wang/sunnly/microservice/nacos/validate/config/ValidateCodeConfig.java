package wang.sunnly.microservice.nacos.validate.config;

import wang.sunnly.microservice.nacos.validate.service.ImageValidateService;
import wang.sunnly.microservice.nacos.validate.service.MailValidateService;
import wang.sunnly.microservice.nacos.validate.service.SmsValidateService;
import wang.sunnly.microservice.nacos.validate.service.ValidateCodeStorage;
import wang.sunnly.microservice.nacos.validate.service.impl.ImageValidateServiceImpl;
import wang.sunnly.microservice.nacos.validate.service.impl.MailValidateServiceImpl;
import wang.sunnly.microservice.nacos.validate.service.impl.SmsValidateServiceImpl;
import wang.sunnly.microservice.nacos.validate.service.impl.ValidateCodeStorageImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Sunnly
 * @ClassName ValidateCodeConfig
 * @Date 2019/6/10 0010 21:18
 **/
@Configuration
public class ValidateCodeConfig {

    @Bean
    @ConditionalOnMissingBean(ImageValidateService.class)
    public ImageValidateService imageValidateService(){
        return new ImageValidateServiceImpl();
    }

    @Bean
    @ConditionalOnMissingBean(MailValidateService.class)
    public MailValidateService mailValidateService(){
        return new MailValidateServiceImpl();
    }

    @Bean
    @ConditionalOnMissingBean(SmsValidateService.class)
    public SmsValidateService smsValidateService(){
        return new SmsValidateServiceImpl();
    }

    @Bean
    @ConditionalOnMissingBean(ValidateCodeStorage.class)
    public ValidateCodeStorage validateCodeStorage(){
        return new ValidateCodeStorageImpl();
    }

}
