package com.yueguang.model.dao;

import com.yueguang.model.QueryVo;
import com.yueguang.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IXUserDao {

    /**
     * 查询所有用户，同时获取所有账户信息
     * @return
     */
    List<User> findAll();

    /**
     * 多对多关系映射，查询用户信息，包括权限
     * @return
     */
    List<User> findRouleAll();

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
