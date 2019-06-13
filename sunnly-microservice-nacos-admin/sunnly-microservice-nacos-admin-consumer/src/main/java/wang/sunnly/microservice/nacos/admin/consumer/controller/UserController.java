package wang.sunnly.microservice.nacos.admin.consumer.controller;

import wang.sunnly.microservice.nacos.admin.consumer.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Sunnly
 * @ClassName UserController
 * @Date 2019/5/31 0031 21:34
 **/
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/user1/{id}")
    public String getUserById(@PathVariable("id") String id){
        return userService.get(id);
    }
}
