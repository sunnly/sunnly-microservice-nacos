package wang.sunnly.microservice.nacos.security.core.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

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
public class RefreshPubKeyRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        log.info("初始化用户PubKey");


        log.info("初始化服务pubKey");

    }

    /**
     * 定时刷新服务端pubKey
     */
    @Scheduled(cron = "0 0/1 * * * ?")
    public void refreshServicePubKey(){
        //鉴权服务端提供获取servicePubKey接口
    }

    /**
     * 定时刷新用户pubKey
     */
    @Scheduled(cron = "0 0/1 * * * ?")
    public void refreshUserPubKey(){
        //鉴权服务端提供获取servicePubKey接口
    }
}
