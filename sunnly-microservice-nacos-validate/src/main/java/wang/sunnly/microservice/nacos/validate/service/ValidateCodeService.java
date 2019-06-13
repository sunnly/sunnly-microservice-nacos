package wang.sunnly.microservice.nacos.validate.service;

import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Sunnly
 * @ClassName ValidateCodeService
 * @Date 2019/6/10 0010 21:17
 **/
public interface ValidateCodeService {

    public void genValidateCode(ServletWebRequest request, String type, String id);

    public boolean validate(ServletWebRequest request, String type, String id, String code);
}
