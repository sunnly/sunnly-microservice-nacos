package wang.sunnly.microservice.nacos.security.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author Sunnly
 * @ClassName SecurityOAuthApplication
 * @Date 2019/6/12 0012 23:42
 **/
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("wang.sunnly.microservice.nacos.security.oauth.mapper")
public class SecurityOAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(SecurityOAuthApplication.class,args);
    }
}
