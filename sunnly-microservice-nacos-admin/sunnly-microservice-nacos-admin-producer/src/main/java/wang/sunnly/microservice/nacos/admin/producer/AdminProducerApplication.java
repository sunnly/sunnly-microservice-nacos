package wang.sunnly.microservice.nacos.admin.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author Sunnly
 * @ClassName AdminProducerApplication
 * @Date 2019/5/31 0031 19:20
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
@MapperScan("wang.sunnly.microservice.nacos.admin.producer.mapper")
public class AdminProducerApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminProducerApplication.class, args);
    }
}
