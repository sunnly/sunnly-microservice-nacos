package wang.sunnly.microservice.nacos.admin.producer.mapper;

import wang.sunnly.microservice.nacos.admin.producer.entity.TbUser;
import wang.sunnly.microservice.nacos.admin.producer.entity.TbUserExample;
import wang.sunnly.tk.mybatis.mapper.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbUserMapper extends MyMapper<TbUser> {
    long countByExample(TbUserExample example);

    int deleteByExample(TbUserExample example);

    List<TbUser> selectByExample(TbUserExample example);

    int updateByExampleSelective(@Param("record") TbUser record, @Param("example") TbUserExample example);

    int updateByExample(@Param("record") TbUser record, @Param("example") TbUserExample example);
}