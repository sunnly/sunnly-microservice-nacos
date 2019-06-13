package wang.sunnly.microservice.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Sunnly
 * @ClassName TestDemoApplication
 * @Date 2019/6/10 0010 21:09
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class TestDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestDemoApplication.class,args);
    }
}
