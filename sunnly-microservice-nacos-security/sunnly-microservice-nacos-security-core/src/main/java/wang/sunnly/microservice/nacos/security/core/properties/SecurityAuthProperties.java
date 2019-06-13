package wang.sunnly.microservice.nacos.security.core.properties;

/**
 * @author Sunnly
 * @ClassName SecurityAuthProperties
 * @Date 2019/6/12 0012 21:42
 **/
public class SecurityAuthProperties {

    //鉴权服务端ID
    private String serviceId = "sunnly_auth";
    private wang.sunnly.microservice.nacos.security.core.properties.SecurityUserProperties user = new wang.sunnly.microservice.nacos.security.core.properties.SecurityUserProperties();
    private wang.sunnly.microservice.nacos.security.core.properties.SecurityClientProperties client = new wang.sunnly.microservice.nacos.security.core.properties.SecurityClientProperties();

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public wang.sunnly.microservice.nacos.security.core.properties.SecurityUserProperties getUser() {
        return user;
    }

    public void setUser(wang.sunnly.microservice.nacos.security.core.properties.SecurityUserProperties user) {
        this.user = user;
    }

    public wang.sunnly.microservice.nacos.security.core.properties.SecurityClientProperties getClient() {
        return client;
    }

    public void setClient(wang.sunnly.microservice.nacos.security.core.properties.SecurityClientProperties client) {
        this.client = client;
    }
}
