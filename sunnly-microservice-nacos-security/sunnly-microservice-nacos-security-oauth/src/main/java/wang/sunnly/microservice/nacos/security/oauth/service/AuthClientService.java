package wang.sunnly.microservice.nacos.security.oauth.service;

import wang.sunnly.microservice.server.common.service.BaseService;
import wang.sunnly.tk.mybatis.mapper.MyMapper;

public interface AuthClientService {


    String generateToken(String clientId, String secret) throws Exception;
}
