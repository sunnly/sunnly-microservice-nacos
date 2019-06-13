package wang.sunnly.microservice.nacos.admin.consumer.controller;

import wang.sunnly.microservice.nacos.admin.consumer.service.TbUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Sunnly
 * @ClassName TbUserController
 * @Date 2019/5/31 0031 23:07
 **/
@RestController
@RequestMapping("user")
public class TbUserController {

    @Resource
    private TbUserService tbUserService;

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") String id){
        return tbUserService.getUserById(id);
    }
}
