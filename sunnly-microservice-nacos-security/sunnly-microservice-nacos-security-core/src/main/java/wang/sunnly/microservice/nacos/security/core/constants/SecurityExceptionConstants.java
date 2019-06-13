package wang.sunnly.microservice.nacos.security.core.constants;

import org.apache.commons.lang3.StringUtils;
import wang.sunnly.microservice.nacos.security.core.exception.SecurityTokenException;

/**
 * @author Sunnly
 * @ClassName SercutityExceptionConstants
 * @Date 2019/6/13 16:06
 * @Version 1.0
 */
public enum SecurityExceptionConstants {

    //服务鉴权异常
    //配置类5030X
    TOKEN_HEADER_NOT_CONFIG("50001","未配置sunnly.security.auth.client.token-header"),
    //Token不合法 5031X
    TOKEN_NOT_NULL("50310","未携带token"),

    //用户鉴权异常
    //配置类5035X
    //Token不合法 5036X

    OTHER_ERROR("50002","其他异常");

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
