package wang.sunnly.microservice.nacos.admin.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Sunnly
 * @ClassName AdminConsumerApplication
 * @Date 2019/5/31 0031 20:17
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
//@MappingS
public class AdminConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminConsumerApplication.class, args);
    }
}
