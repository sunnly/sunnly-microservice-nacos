package wang.sunnly.microservice.nacos.security.oauth.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import wang.sunnly.microservice.nacos.security.core.constants.SecurityExceptionConstants;
import wang.sunnly.microservice.nacos.security.core.exception.SecurityTokenException;
import wang.sunnly.microservice.nacos.security.core.utils.client.ClientInfo;
import wang.sunnly.microservice.nacos.security.core.utils.jwt.JWTHelper;
import wang.sunnly.microservice.nacos.security.oauth.entity.AuthClient;
import wang.sunnly.microservice.nacos.security.oauth.mapper.AuthClientMapper;
import wang.sunnly.microservice.nacos.security.oauth.properties.PubPriKeyProperties;
import wang.sunnly.microservice.nacos.security.oauth.service.AuthClientService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AuthClientServiceImpl implements AuthClientService{

    @Resource
    private AuthClientMapper authClientMapper;

    @Value("${sunnly.security.auth.client.expire}")
    private int expire = 3600;

    @Autowired
    private PubPriKeyProperties pubPriKeyProperties;

    @Override
    public String generateToken(String clientId, String secret) throws Exception {
        //验证clientId和secret的合法性
        AuthClient client = getClient(clientId, secret);
        //生成token
        return JWTHelper.generateToken(new ClientInfo(client.getCode(),client.getName(),client.getId().toString()),
                pubPriKeyProperties.getServicePriKey(),expire);
    }

    @Override
    public List<String> getAllowClient(String clientId, String secret) {
        AuthClient client = getClient(clientId, secret);
        List<String> allowClient = authClientMapper.getAllowClient(client.getId());
        return allowClient == null ? Lists.newArrayList() : allowClient;
    }

    @Override
    public void validate(String clientId, String secret){
        getClient(clientId,secret);
    }

    private AuthClient getClient(String clientId, String secret){
        if (StringUtils.isEmpty(clientId)||StringUtils.isEmpty(secret)){
            throw new SecurityTokenException(SecurityExceptionConstants.CLIENT_OR_SECRENT_ERROR);
        }
        AuthClient client = new AuthClient();
        client.setCode(clientId);
        client = authClientMapper.selectOne(client);
        if (client !=null && !StringUtils.equals(client.getSecret(),secret)){
            //clientId和secret非法
            throw new SecurityTokenException(SecurityExceptionConstants.CLIENT_OR_SECRENT_ERROR);
        }
        return client;
    }

}
