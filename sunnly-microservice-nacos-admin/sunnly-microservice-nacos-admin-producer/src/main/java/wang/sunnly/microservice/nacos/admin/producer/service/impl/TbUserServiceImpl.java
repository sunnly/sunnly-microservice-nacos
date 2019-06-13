package wang.sunnly.microservice.nacos.admin.producer.service.impl;

import wang.sunnly.microservice.nacos.admin.producer.mapper.TbUserMapper;
import wang.sunnly.microservice.nacos.admin.producer.service.TbUserService;
import wang.sunnly.microservice.server.common.service.BaseService;
import wang.sunnly.microservice.server.common.service.impl.BaseServiceImpl;
import wang.sunnly.tk.mybatis.mapper.MyMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class TbUserServiceImpl<M extends MyMapper<E>,E>
        extends BaseServiceImpl<M,E>
        implements TbUserService<M, E>, BaseService<M,E> {

    @Resource
    private TbUserMapper tbUserMapper;


}
