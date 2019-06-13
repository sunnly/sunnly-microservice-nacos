package wang.sunnly.microservice.nacos.admin.producer.wiremock;

import com.github.tomakehurst.wiremock.client.WireMock;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

/**
 * @author Sunnly
 * @ClassName MockService
 * @Date 2019/6/2 0002 19:59
 **/
public class MockService {
    public static void main(String[] args) throws IOException {
        WireMock.configureFor("192.168.101.57",9089);
//        WireMock.configureFor(8877);
        WireMock.removeAllMappings();

        MockService.mock("01.txt","/order/1");
        MockService.mock("02.txt","/order/3");
    }

    public static void mock(String file, String url) throws IOException {
        ClassPathResource resource = new ClassPathResource("mock/resources/" + file);
        String content = StringUtils.join(FileUtils.readLines(resource.getFile(),"UTF-8").toArray(),"\n");
//                FileUtils.readFileToString(resource.getFile());

        WireMock.stubFor(WireMock.get(WireMock.urlEqualTo(url))
                .willReturn(WireMock.aResponse()
                        .withBody(content)
//                        .withBody("{\"id\":22,\"name\":\"sunnly11\"}")
                        .withStatus(200)));
    }


}
