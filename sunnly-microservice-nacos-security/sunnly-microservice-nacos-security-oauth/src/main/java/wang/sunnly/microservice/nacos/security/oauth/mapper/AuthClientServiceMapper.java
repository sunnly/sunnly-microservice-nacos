package wang.sunnly.microservice.nacos.security.oauth.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import wang.sunnly.microservice.nacos.security.oauth.entity.AuthClientService;
import wang.sunnly.microservice.nacos.security.oauth.entity.AuthClientServiceExample;
import wang.sunnly.tk.mybatis.mapper.MyMapper;

public interface AuthClientServiceMapper extends MyMapper<AuthClientService> {
    long countByExample(AuthClientServiceExample example);

    int deleteByExample(AuthClientServiceExample example);

    List<AuthClientService> selectByExample(AuthClientServiceExample example);

    int updateByExampleSelective(@Param("record") AuthClientService record, @Param("example") AuthClientServiceExample example);

    int updateByExample(@Param("record") AuthClientService record, @Param("example") AuthClientServiceExample example);
}