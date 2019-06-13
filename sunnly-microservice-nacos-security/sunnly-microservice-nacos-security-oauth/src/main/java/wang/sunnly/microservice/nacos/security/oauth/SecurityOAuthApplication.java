package wang.sunnly.microservice.nacos.security.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Sunnly
 * @ClassName SecurityOAuthApplication
 * @Date 2019/6/12 0012 23:42
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class SecurityOAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(SecurityOAuthApplication.class,args);
    }
}
