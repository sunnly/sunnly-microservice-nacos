package wang.sunnly.microservice.nacos.security.oauth.properties;

/**
 * @author Sunnly
 * @ClassName PubPriKeyProperties
 * @Date 2019/6/12 0012 23:32
 **/
public class PubPriKeyProperties {

    private String userSecret;
    private String serviceSecret;
    private byte[] userPubKey;
    private byte[] userPriKey;
    private byte[] servicePriKey;
    private byte[] servicePubKey;
}
