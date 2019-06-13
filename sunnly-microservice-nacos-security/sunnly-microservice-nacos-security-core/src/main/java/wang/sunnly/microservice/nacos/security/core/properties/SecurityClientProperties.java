package wang.sunnly.microservice.nacos.security.core.properties;

/**
 * @author Sunnly
 * @ClassName SecurityClientProperties
 * @Date 2019/6/12 0012 21:49
 **/
public class SecurityClientProperties {

    private String id;
    private String secret;
    private String tokenHeader;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getTokenHeader() {
        return tokenHeader;
    }

    public void setTokenHeader(String tokenHeader) {
        this.tokenHeader = tokenHeader;
    }
}
