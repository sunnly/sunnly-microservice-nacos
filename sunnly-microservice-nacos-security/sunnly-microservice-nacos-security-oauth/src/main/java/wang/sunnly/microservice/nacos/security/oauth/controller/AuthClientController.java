package wang.sunnly.microservice.nacos.security.oauth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.sunnly.microservice.nacos.security.oauth.service.AuthClientService;
import wang.sunnly.microservice.server.common.msg.ObjectRestResponse;

/**
 *
 * @author Sunnly
 * @ClassName ClientController
 * @Date 2019/6/13 0013 22:45
 **/
@RestController
@RequestMapping("client")
public class AuthClientController {

    @Autowired
    private AuthClientService authClientService;
    /**
     * 根据clientId和secret换取服务端token
     * @param clientId
     * @param secret
     * @return
     */
    @PostMapping("/token")
    public ObjectRestResponse<String> getToken(String clientId, String secret) throws Exception {
        return new ObjectRestResponse<String>().data(authClientService.generateToken(clientId,secret));
    }

    /**
     * 获取允许访问的微服务
     * @param clientId
     * @param secret
     * @return
     */
    @GetMapping("/myClient")
    public ObjectRestResponse getAllowClient(String clientId, String secret) throws Exception {
        getToken(clientId,secret);
        return null;
    }

    /**
     * 获取服务pubKey
     * @param clientId
     * @param secret
     * @return
     */
    @PostMapping("/servicePubKey")
    public ObjectRestResponse getServicePubKey(String clientId, String secret){
        return null;
    }

    /**
     * 获取用户pubKey
     * @param clientId
     * @param secret
     * @return
     */
    @PostMapping("/userPubKey")
    public ObjectRestResponse getUserPubKey(String clientId, String secret){
        return null;
    }

}
