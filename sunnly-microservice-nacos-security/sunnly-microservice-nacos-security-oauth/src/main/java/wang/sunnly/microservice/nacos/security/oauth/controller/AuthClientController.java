package wang.sunnly.microservice.nacos.security.oauth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.sunnly.microservice.nacos.security.oauth.properties.PubPriKeyProperties;
import wang.sunnly.microservice.nacos.security.oauth.service.AuthClientService;
import wang.sunnly.microservice.server.common.msg.ObjectRestResponse;

import java.util.List;

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

    @Autowired
    private PubPriKeyProperties pubPriKeyProperties;
    /**
     * 根据clientId和secret换取服务端token
     * @param clientId
     * @param secret
     * @return
     */
    @PostMapping("/token")
    public ObjectRestResponse<String> getAccessToken(String clientId, String secret) throws Exception {
        return new ObjectRestResponse<String>().data(authClientService.generateToken(clientId,secret));
    }

    /**
     * 获取允许哪些微服务请求我
     * @param clientId
     * @param secret
     * @return
     */
    @GetMapping("/myClient")
    public ObjectRestResponse getAllowClient(String clientId, String secret) throws Exception {
        List<String> allowClient = authClientService.getAllowClient(clientId, secret);
//        ObjectRestResponse<String> a = getToken(clientId, secret);
        return new ObjectRestResponse<List<String>>().data(allowClient);
    }

    /**
     * 获取服务pubKey，公钥一般不会变
     * 这里主要是验证是否修改了权限
     * @param clientId
     * @param secret
     * @return
     */
    @PostMapping("/servicePubKey")
    public ObjectRestResponse getServicePubKey(String clientId, String secret){
        //验证clientId和secret的有效性
        authClientService.validate(clientId,secret);
        return new ObjectRestResponse<byte[]>().data(pubPriKeyProperties.getServicePubKey());
    }

    /**
     * 获取用户pubKey
     * @param clientId
     * @param secret
     * @return
     */
    @PostMapping("/userPubKey")
    public ObjectRestResponse getUserPubKey(String clientId, String secret){
        //验证clientId和secret的有效性
        authClientService.validate(clientId,secret);
        return new ObjectRestResponse<byte[]>().data(pubPriKeyProperties.getUserPubKey());
    }

    @GetMapping("/validate")
    public boolean validateClientIdAndSecret(String clientId, String secret){
        try {
            authClientService.validate(clientId,secret);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
