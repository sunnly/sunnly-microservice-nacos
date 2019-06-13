package wang.sunnly.microservice.nacos.admin.producer.service;

import wang.sunnly.microservice.server.common.service.BaseService;
import wang.sunnly.tk.mybatis.mapper.MyMapper;

public interface TbUserService<M extends MyMapper<E>,E> extends BaseService<M,E> {

}
