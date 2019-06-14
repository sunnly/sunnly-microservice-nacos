package wang.sunnly.microservice.nacos.security.client.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * 忽略用户鉴权
 * @author Sunnly
 * @Date 2019/6/12 20:15
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value={ElementType.METHOD,ElementType.TYPE})
public @interface IgnoreServiceToken {
}
