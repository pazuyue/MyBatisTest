package com.yueguang.model.dao;

import com.yueguang.model.QueryVo;
import com.yueguang.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IXUserDao {

    /**
     * 查询所有
     * @return
     */
    List<User> findAll();

    /**
     * 传入根据条件查询
     * @param user
     * @return
     */
    List<User> findUserByCondition(User user);

    /**
     * 根据ID集合查询所有
     * @param queryVo
     * @return
     */
    List<User> findUserInIds(QueryVo queryVo);

    int saveUser(User user);
}
