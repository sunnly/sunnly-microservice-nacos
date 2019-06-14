package wang.sunnly.microservice.nacos.security.core.constants;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Sunnly
 * @ClassName SercutityExceptionConstants
 * @Date 2019/6/13 16:06
 * @Version 1.0
 */
public enum SecurityExceptionConstants {

    //服务鉴权异常
    //配置类5030X
    TOKEN_HEADER_NOT_CONFIG("50001","Please configure: sunnly.security.auth.client.token-header"),
    //Token验证失败 5031X
    TOKEN_EMPTY("50310","Client token is null or empty!"),
    TOKEN_EXPIRED("50311","Client token expired!"),
    TOKEN_SIGNATURE_ERROR("50312","Client token signature error!"),

    CLIENT_OR_SECRENT_ERROR("50320","Client not found or Client secret is error!"),

    NETWORK_CONNECTION_ERR("50330","网络连接错误"),
    //用户鉴权异常
    //配置类5035X
    //Token不合法 5036X

    TOHER_ERROR("50002","其他异常");

    private String code;
    private String msg;

    private SecurityExceptionConstants(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode(){
        return this.code;
    }

    public String getMsg(){
        return this.msg;
    }

    public static String getMsg(String code){
        for (SecurityExceptionConstants s : SecurityExceptionConstants.values()){
            if (StringUtils.equals(code,s.code))
                return s.getMsg();
        }
        return null;
    }

}
