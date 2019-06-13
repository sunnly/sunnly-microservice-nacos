package wang.sunnly.microservice.nacos.security.oauth.service;

import wang.sunnly.microservice.nacos.security.oauth.mapper.AuthClientServiceMapper;
import wang.sunnly.microservice.nacos.security.oauth.entity.AuthClientServiceExample;
import wang.sunnly.microservice.nacos.security.oauth.entity.AuthClientService;

import java.util.List;

public interface AuthClientServiceService{


    long countByExample(AuthClientServiceExample example);

    int deleteByExample(AuthClientServiceExample example);

    List<AuthClientService> selectByExample(AuthClientServiceExample example);

    int updateByExampleSelective(AuthClientService record,AuthClientServiceExample example);

    int updateByExample(AuthClientService record,AuthClientServiceExample example);

}
