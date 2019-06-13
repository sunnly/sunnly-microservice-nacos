package wang.sunnly.microservice.server.common.service;

import wang.sunnly.microservice.server.common.entity.MyExample;
import wang.sunnly.microservice.server.common.msg.ListRestResponse;
import wang.sunnly.microservice.server.common.msg.ObjectRestResponse;
import wang.sunnly.microservice.server.common.msg.TableResultResponse;
import wang.sunnly.tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface BaseService<M extends MyMapper<E>,E> {

    /**
     * 查询
     *
     * @param entity
     * @return
     */
    E selectOne(E entity);

    /**
     * 通过Id查询
     *
     * @param id
     * @return
     */
    E selectById(Object id);

    /**
     * 查询列表
     *
     * @param entity
     * @return
     */
    List<E> selectList(E entity);

    List<E> selectByExample(MyExample example);

    int selectCount();

    public int selectCount(MyExample example);
    /**
     * 获取所有对象
     *
     * @return
     */
    List<E> selectListAll();

    List<E> selectListByPage(int pageNo, int pageSize);

    List<E> selectList(MyExample example, int pageNo, int pageSize);

    TableResultResponse<E> selectToTableRestResponse(MyExample example, int pageNo, int pageSize);

    ObjectRestResponse<E> selectToObjectRestResponse(MyExample example);

    ObjectRestResponse<E> selectToObjectRestResponse(E entity);

    ListRestResponse<E> selectToListRestResponse(MyExample example, int pageNo, int pageSize);

    /**
     * 查询总记录数
     *
     * @param entity
     * @return
     */
    int selectCount(E entity);

    /**
     * 添加
     *
     * @param entity
     */
    void insert(E entity);


    /**
     * 插入 不插入null字段
     *
     * @param entity
     */
    void insertSelective(E entity);

    /**
     * 删除
     *
     * @param entity
     */
    void delete(E entity);

    /**
     * 根据Id删除
     *
     * @param id
     */
    void deleteById(Object id);


    /**
     * 根据id更新
     *
     * @param entity
     */
    void updateById(E entity);


    /**
     * 不update null
     *
     * @param entity
     */
    void updateSelectiveById(E entity);
}
