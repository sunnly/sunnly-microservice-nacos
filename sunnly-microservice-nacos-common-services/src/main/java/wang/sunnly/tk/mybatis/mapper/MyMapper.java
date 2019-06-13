package wang.sunnly.tk.mybatis.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface MyMapper<E> extends Mapper<E>, MySqlMapper<E>{
}
