package wang.sunnly.microservice.nacos.security.oauth.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import wang.sunnly.microservice.nacos.security.oauth.entity.AuthClient;
import wang.sunnly.microservice.nacos.security.oauth.entity.AuthClientExample;
import wang.sunnly.tk.mybatis.mapper.MyMapper;

public interface AuthClientMapper extends MyMapper<AuthClient> {
    long countByExample(AuthClientExample example);

    int deleteByExample(AuthClientExample example);

    List<AuthClient> selectByExample(AuthClientExample example);

    int updateByExampleSelective(@Param("record") AuthClient record, @Param("example") AuthClientExample example);

    int updateByExample(@Param("record") AuthClient record, @Param("example") AuthClientExample example);
}