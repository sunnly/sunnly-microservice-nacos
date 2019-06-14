package wang.sunnly.microservice.nacos.security.client.service.impl;

import org.springframework.stereotype.Service;
import wang.sunnly.microservice.nacos.security.client.service.SecurityAuthServiceService;
import wang.sunnly.microservice.nacos.security.core.constants.SecurityExceptionConstants;
import wang.sunnly.microservice.nacos.security.core.exception.SecurityTokenException;
import wang.sunnly.microservice.server.common.msg.ObjectRestResponse;

/**
 * @author Sunnly
 * @ClassName SercurityAuthServiceServiceImpl
 * @Date 2019/6/14 11:21
 * @Version 1.0
 */
@Service
public class SecurityAuthServiceServiceImpl implements SecurityAuthServiceService {
    @Override
    public ObjectRestResponse getAccessToken(String clientId, String secret) {
        throw new SecurityTokenException(SecurityExceptionConstants.NETWORK_CONNECTION_ERR);
    }

    @Override
    public ObjectRestResponse getAllowClient(String clientId, String secret) {
        throw new SecurityTokenException(SecurityExceptionConstants.NETWORK_CONNECTION_ERR);
    }

    @Override
    public ObjectRestResponse getServicePubKey(String clientId, String secret) {
        throw new SecurityTokenException(SecurityExceptionConstants.NETWORK_CONNECTION_ERR);
    }

    @Override
    public ObjectRestResponse getUserPubKey(String clientId, String secret) {
        throw new SecurityTokenException(SecurityExceptionConstants.NETWORK_CONNECTION_ERR);
    }

    @Override
    public boolean validateClientIdAndSecret(String clientId, String secret) {
        throw new SecurityTokenException(SecurityExceptionConstants.NETWORK_CONNECTION_ERR);
    }
}
