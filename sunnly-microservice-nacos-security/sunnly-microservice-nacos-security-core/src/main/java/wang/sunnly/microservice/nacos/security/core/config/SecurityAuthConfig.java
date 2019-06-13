package wang.sunnly.microservice.nacos.security.core.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author Sunnly
 * @ClassName SecurityAuthConfig
 * @Date 2019/6/13 0013 21:16
 **/
@Data
@Component
public class SecurityAuthConfig {

    private byte[] pubKeyByte;
    @Value("${sunnly.security.auth.client.id:null}")
    private String clientId;

    @Value("${sunnly.security.auth.client.secret}")
    private String clientSecret;

    @Value("${sunnly.security.auth.client.token-header}")
    private String tokenHeader;

    @Value("${spring.application.name}")
    private String applicationName;
}
