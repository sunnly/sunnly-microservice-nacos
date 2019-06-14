//package wang.sunnly.microservice.nacos.service;
//
//import wang.sunnly.microservice.nacos.validate.service.SmsValidateService;
//import org.springframework.web.context.request.ServletWebRequest;
//
//import javax.servlet.ServletOutputStream;
//import java.io.IOException;
//
///**
// * @author Sunnly
// * @ClassName MySmsValidateCodeServicesImpl
// * @Date 2019/6/10 0010 23:22
// **/
//public class MySmsValidateCodeServicesImpl implements SmsValidateService {
//    @Override
//    public boolean sender(ServletWebRequest request, String phone, String code) {
//        System.out.println();
//        ServletOutputStream out = null;
//        try {
//            request.getResponse().setContentType("text/html;charset=UTF-8");
//            request.getResponse().setCharacterEncoding("UTF-8");
//            out = request.getResponse().getOutputStream();
//            out.write(String.format("我是来打酱油的，手机【%s】:%s",phone,code).getBytes());
//            out.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            if (out !=null){
//                try {
//                    out.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return true;
//    }
//}
