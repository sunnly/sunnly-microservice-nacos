package wang.sunnly.microservice.nacos.security.client.interceptor;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import wang.sunnly.microservice.nacos.security.client.annotation.IgnoreServiceToken;
import wang.sunnly.microservice.nacos.security.client.properties.SecurityProperties;
import wang.sunnly.microservice.nacos.security.core.constants.SecurityExceptionConstants;
import wang.sunnly.microservice.nacos.security.core.exception.SecurityTokenException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * 服务鉴权拦截器
 * @author Sunnly
 * @ClassName ServiceAuthRestInterceptor
 * @Date 2019/6/12 0012 20:15
 **/
public class ServiceAuthInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private SecurityProperties securityProperties;

//    @Autowired
//    private SecurityAuthServiceConfig securityAuthServiceController;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        //获取IgnoreServiceToken注解
        IgnoreServiceToken annotation = handlerMethod.getBeanType().getAnnotation(IgnoreServiceToken.class);
        if (annotation == null){
            annotation = handlerMethod.getMethodAnnotation(IgnoreServiceToken.class);
        }
        if (annotation != null){
            //配置了不需要验证的注解，直接放行
            return super.preHandle(request, response, handler);
        }
        //未配置忽略注解，判断是否在配置中进行
        //获取header中的token,key值从配置文件sunnly.security.auth.client.token-header中获取
        String tokenKey = securityProperties.getAuth().getClient().getTokenHeader();
        if (StringUtils.isEmpty(tokenKey)){
            throw new SecurityTokenException(SecurityExceptionConstants.TOKEN_HEADER_NOT_CONFIG);
        }
        //获取请求头中的token
        String headerToken = request.getHeader(tokenKey);

        if(StringUtils.isEmpty(headerToken)){
            //从cookies中取
            if (request.getCookies() !=null){
                for (Cookie cookie : request.getCookies()){
                    if (StringUtils.equals(cookie.getName(),tokenKey)){
                        headerToken = cookie.getValue();
                    }
                }
            }
        }
        if(StringUtils.isEmpty(headerToken)){
            throw new SecurityTokenException(SecurityExceptionConstants.TOKEN_EMPTY);
        }
        //解析请求头中的token，服务端token需要通过公钥解析，从鉴权服务器获取公钥



        return super.preHandle(request, response, handler);
    }
}
