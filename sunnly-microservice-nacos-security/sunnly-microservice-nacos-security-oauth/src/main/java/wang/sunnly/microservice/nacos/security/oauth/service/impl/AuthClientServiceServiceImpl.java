package wang.sunnly.microservice.nacos.security.oauth.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import wang.sunnly.microservice.nacos.security.oauth.mapper.AuthClientServiceMapper;
import wang.sunnly.microservice.nacos.security.oauth.entity.AuthClientServiceExample;
import wang.sunnly.microservice.nacos.security.oauth.entity.AuthClientService;
import wang.sunnly.microservice.nacos.security.oauth.service.AuthClientServiceService;

import java.util.List;

@Service
public class AuthClientServiceServiceImpl implements AuthClientServiceService{

    @Resource
    private AuthClientServiceMapper authClientServiceMapper;

    @Override
    public long countByExample(AuthClientServiceExample example) {
        return authClientServiceMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(AuthClientServiceExample example) {
        return authClientServiceMapper.deleteByExample(example);
    }

    @Override
    public List<AuthClientService> selectByExample(AuthClientServiceExample example) {
        return authClientServiceMapper.selectByExample(example);
    }

    @Override
    public int updateByExampleSelective(AuthClientService record,AuthClientServiceExample example) {
        return authClientServiceMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(AuthClientService record,AuthClientServiceExample example) {
        return authClientServiceMapper.updateByExample(record,example);
    }

}
