package wang.sunnly.microservice.nacos.security.core.exception;

import wang.sunnly.microservice.nacos.security.core.constants.SecurityExceptionConstants;

/**
 * 自定义异常
 * @author Sunnly
 * @ClassName SecurityTokenException
 * @Date 2019/6/13 15:51
 * @Version 1.0
 */
public class SecurityTokenException extends RuntimeException {

    public SecurityTokenException(SecurityExceptionConstants ex){
        super(ex.getCode());
    }

}
