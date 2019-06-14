package wang.sunnly.microservice.nacos.security.client.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import wang.sunnly.microservice.nacos.security.client.properties.SecurityProperties;
import wang.sunnly.microservice.nacos.security.client.service.SecurityAuthServiceService;
import wang.sunnly.microservice.server.common.msg.ObjectRestResponse;

/**
 *
 * 系统启动时初始化服务和用户的pubKey
 * 并且定时去验证权限是否被改变
 * @author Sunnly
 * @ClassName PubKey
 * @Date 2019/6/13 0013 21:54
 **/
@Configuration
@Slf4j
@EnableScheduling
public class RefreshPubKeyRunner implements CommandLineRunner {

    @Autowired
    private SecurityAuthServiceService securityAuthServiceService;

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void run(String... args) throws Exception {
        log.info("初始化用户PubKey");
        getUserPublicKey();
        log.info("初始化服务pubKey");
        getServicePublicKey();

    }

    /**
     * 定时刷新验证clientId和secret是否发生改变
     */
    @Scheduled(cron = "0 0/5 * * * ?")
    public void validateClientIdAndSecret(){
        //鉴权服务端提供获取servicePubKey接口
        try {
            boolean validate = securityAuthServiceService.validateClientIdAndSecret(
                    securityProperties.getAuth().getClient().getId(),
                    securityProperties.getAuth().getClient().getSecret());
            if (validate) {
                //验证成功
                return;
            }
        }catch (Exception e){}
        //TODO 验证失败,清除信息
        securityProperties.getAuth().getClient().setPubKeyByte(null);
        securityProperties.getAuth().getUser().setPubKeyByte(null);
    }

    /**
     *
     * 如果pubKey为空，则去重新获取
     *
     * @Author Sunnly
     * @Date
     * @Param
     * @return
     **/
    @Scheduled(cron = "0 0/1 * * * ?")
    public void validateClientIdAndSecret1(){
        if (RefreshPubKeyRunner.isNull(securityProperties.getAuth().getUser().getPubKeyByte())
                || RefreshPubKeyRunner.isNull(securityProperties.getAuth().getClient().getPubKeyByte())){
            log.info("重新获取用户PubKey");
            getUserPublicKey();
            log.info("重新获取服务PubKey");
            getServicePublicKey();
        }
    }

    public static boolean isNull(byte[] bytes){
        return bytes == null || bytes.length ==0;
    }

    private void getUserPublicKey(){

        ObjectRestResponse<byte[]> userPubKey = securityAuthServiceService.getUserPubKey(
                securityProperties.getAuth().getClient().getId(),
                securityProperties.getAuth().getClient().getSecret());
        if (userPubKey.getStatus() == HttpStatus.OK.value()){
            securityProperties.getAuth().getClient().setPubKeyByte(userPubKey.getData());
        }

    }

    private void getServicePublicKey(){
        ObjectRestResponse<byte[]> servicePubKey = securityAuthServiceService.getServicePubKey(
                securityProperties.getAuth().getClient().getId(),
                securityProperties.getAuth().getClient().getSecret());
        if (servicePubKey.getStatus() == HttpStatus.OK.value()){
            securityProperties.getAuth().getClient().setPubKeyByte(servicePubKey.getData());
        }
    }

}
