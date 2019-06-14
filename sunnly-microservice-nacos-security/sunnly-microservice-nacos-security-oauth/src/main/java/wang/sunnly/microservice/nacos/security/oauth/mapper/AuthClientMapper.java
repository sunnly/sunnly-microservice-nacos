package wang.sunnly.microservice.nacos.security.oauth.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import wang.sunnly.microservice.nacos.security.oauth.entity.AuthClient;
import wang.sunnly.microservice.nacos.security.oauth.entity.AuthClientExample;
import wang.sunnly.tk.mybatis.mapper.MyMapper;

public interface AuthClientMapper extends MyMapper<AuthClient> {

    @Select("SELECT c.CODE " +
            "FROM auth_client c " +
            "INNER JOIN auth_client_service gcs " +
            "ON gcs.client_id = c.id " +
            "WHERE gcs.service_id = #{serviceId}")
    List<String> getAllowClient(Integer id);
}