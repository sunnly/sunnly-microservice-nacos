package wang.sunnly.microservice.nacos.security.client.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wang.sunnly.microservice.nacos.security.client.service.impl.SecurityAuthServiceServiceImpl;
import wang.sunnly.microservice.server.common.msg.ObjectRestResponse;

/**
 * @author Sunnly
 * @ClassName SecutityAuthServiceService
 * @Date 2019/6/13 0013 20:55
 **/
@FeignClient(value = "${sunnly.security.auth.service-id}", fallback = SecurityAuthServiceServiceImpl.class)
public interface SecurityAuthServiceService {

    @PostMapping("/client/token")
    ObjectRestResponse getAccessToken(@RequestParam("clientId") String clientId,
                                      @RequestParam("secret") String secret);

    @GetMapping("/client/myClient")
    public ObjectRestResponse getAllowClient(String clientId, String secret);

    @PostMapping("/client/servicePubKey")
    public ObjectRestResponse getServicePubKey(String clientId, String secret);

    @PostMapping("/client/userPubKey")
    public ObjectRestResponse getUserPubKey(String clientId, String secret);

    @GetMapping("/client/validate")
    public boolean validateClientIdAndSecret(String clientId, String secret);

}
