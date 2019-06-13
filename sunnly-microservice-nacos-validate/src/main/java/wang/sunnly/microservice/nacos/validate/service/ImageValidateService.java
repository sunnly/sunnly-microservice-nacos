package wang.sunnly.microservice.nacos.validate.service;

import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;

public interface ImageValidateService {
    public boolean sender(ServletWebRequest request, String code, int width, int height);

}
