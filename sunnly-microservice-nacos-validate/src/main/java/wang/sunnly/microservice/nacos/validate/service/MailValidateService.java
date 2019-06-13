package wang.sunnly.microservice.nacos.validate.service;

import org.springframework.web.context.request.ServletWebRequest;

public interface MailValidateService {
    public boolean sender(ServletWebRequest request, String mail, String code);
}
