package wang.sunnly.microservice.nacos.security.oauth.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import wang.sunnly.microservice.nacos.security.core.utils.jwt.RsaKeyHelper;
import wang.sunnly.microservice.nacos.security.oauth.properties.PubPriKeyProperties;

import java.util.Map;

/**
 *
 * 当SpringBoot启动后执行该任务,对公钥秘钥进行处理
 * @author Sunnly
 * @ClassName OAuthServiceRunning
 * @Date 2019/6/12 0012 23:26
 **/
@Configuration
public class OAuthServiceRunner implements CommandLineRunner {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private PubPriKeyProperties pubPriKeyProperties;

    //Redis中保存公钥秘钥的key值
    private final static String SUNNLY_REDIS_SERVICE_PUB_KEY = "SUNNLY:AUTH:CLIENT:PUB:KEY";
    private final static String SUNNLY_REDIS_SERVICE_PRI_KEY = "SUNNLY:AUTH:CLIENT:PRI:KEY";
    private final static String SUNNLY_REDIS_USER_PUB_KEY = "SUNNLY:AUTH:JWT:PUB:KEY";
    private final static String SUNNLY_REDIS_USER_PRI_KEY = "SUNNLY:AUTH:JWT:PRI:KEY";


    @Override
    public void run(String... args) throws Exception {

        //首先从redis中获取公钥和秘钥封
        if(redisTemplate.hasKey(SUNNLY_REDIS_SERVICE_PUB_KEY)
                &&redisTemplate.hasKey(SUNNLY_REDIS_SERVICE_PRI_KEY)
                &&redisTemplate.hasKey(SUNNLY_REDIS_USER_PUB_KEY)
                &&redisTemplate.hasKey(SUNNLY_REDIS_USER_PRI_KEY)){
            //如果redis中有直接装到PubPriKeyProperties中
            pubPriKeyProperties.setServicePriKey(RsaKeyHelper.toBytes(
                    redisTemplate.opsForValue().get(SUNNLY_REDIS_SERVICE_PRI_KEY)));
            pubPriKeyProperties.setServicePubKey(RsaKeyHelper.toBytes(
                    redisTemplate.opsForValue().get(SUNNLY_REDIS_SERVICE_PUB_KEY)));
            pubPriKeyProperties.setUserPriKey(RsaKeyHelper.toBytes(
                    redisTemplate.opsForValue().get(SUNNLY_REDIS_USER_PRI_KEY)));
            pubPriKeyProperties.setUserPubKey(RsaKeyHelper.toBytes(
                    redisTemplate.opsForValue().get(SUNNLY_REDIS_USER_PUB_KEY)));
        }else {
            //Redis中不存在，将secret作为种子生成伪随机数，这里如果secret种子相同的情况下生成的随机数相同
            Map<String, byte[]> serviceMap = RsaKeyHelper.generateKey(pubPriKeyProperties.getServiceSecret());
            Map<String, byte[]> userMap = RsaKeyHelper.generateKey(pubPriKeyProperties.getUserSecret());
            pubPriKeyProperties.setServicePriKey(serviceMap.get("priKey"));
            pubPriKeyProperties.setServicePubKey(serviceMap.get("pubKey"));
            pubPriKeyProperties.setUserPriKey(userMap.get("priKey"));
            pubPriKeyProperties.setUserPubKey(userMap.get("pubKey"));

            //同时保存到redis中
            redisTemplate.opsForValue().set(SUNNLY_REDIS_SERVICE_PRI_KEY,
                    RsaKeyHelper.toHexString(serviceMap.get("priKey")));
            redisTemplate.opsForValue().set(SUNNLY_REDIS_SERVICE_PUB_KEY,
                    RsaKeyHelper.toHexString(serviceMap.get("pubKey")));
            redisTemplate.opsForValue().set(SUNNLY_REDIS_USER_PRI_KEY,
                    RsaKeyHelper.toHexString(userMap.get("priKey")));
            redisTemplate.opsForValue().set(SUNNLY_REDIS_USER_PUB_KEY,
                    RsaKeyHelper.toHexString(userMap.get("pubKey")));
        }
    }
}
