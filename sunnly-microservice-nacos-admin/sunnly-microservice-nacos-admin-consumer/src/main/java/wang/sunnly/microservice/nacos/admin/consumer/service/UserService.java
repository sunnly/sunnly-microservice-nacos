package wang.sunnly.microservice.nacos.admin.consumer.service;

import wang.sunnly.microservice.nacos.admin.consumer.service.impl.UserServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "admin-producer", fallback = UserServiceFallback.class)
public interface UserService {

    @GetMapping("/user1/{id}")
    public String get(@PathVariable("id") String id);
}
