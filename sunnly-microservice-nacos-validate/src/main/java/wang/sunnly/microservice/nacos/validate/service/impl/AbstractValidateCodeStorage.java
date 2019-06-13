package wang.sunnly.microservice.nacos.validate.service.impl;

import wang.sunnly.microservice.nacos.validate.service.ValidateCodeStorage;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author Sunnly
 * @ClassName ValidateCodeStorageAbstuct
 * @Date 2019/6/11 0011 0:06
 **/
public abstract class AbstractValidateCodeStorage implements ValidateCodeStorage {

    @Override
    public boolean validateAnyIgnoreCase(ServletWebRequest request, String key, String id, String code) {
        return validate(request,key,id,code,false);
    }

    @Override
    public boolean validate(ServletWebRequest request, String key, String id, String code) {
        return validate(request,key,id,code,false);
    }

    @Override
    public boolean validateAnyIgnoreCase(ServletWebRequest request, String key, String id, String code, boolean clear) {
        return validate(request,key,id,code,false);
    }
}
