package wang.sunnly.microservice.nacos.admin.consumer.service;

import wang.sunnly.microservice.nacos.admin.consumer.service.impl.TbUserServicesFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "admin-producer", fallback = TbUserServicesFallback.class)
public interface TbUserService {

    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable("id") String id);
}
