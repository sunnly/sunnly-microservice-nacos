package wang.sunnly.microservice.nacos.security.core.properties;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author Sunnly
 * @ClassName SecurityUserProperties
 * @Date 2019/6/12 0012 21:47
 **/
public class SecurityUserProperties {

    private String tokenHeader;

    public String getTokenHeader() {
        return tokenHeader;
    }

    public void setTokenHeader(String tokenHeader) {
        this.tokenHeader = tokenHeader;
    }
}
