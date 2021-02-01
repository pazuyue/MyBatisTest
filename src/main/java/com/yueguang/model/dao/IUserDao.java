package com.yueguang.model.dao;

import com.yueguang.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IUserDao {

    @Select("select * from user")
    List<User> findAll();

    @Insert("insert into user(username,address,sex,birthday) values(#{username},#{address},#{sex},#{birthday})")
    @Options(useGeneratedKeys=true, keyProperty = "id", keyColumn = "id")
    void  saveUser(User user);

    @Update("update user set username=#{username},address=#{address},sex=#{sex},birthday=#{birthday} where id=#{id}")
    void updateUser(User user);

    @Delete("delete from user where id=#{id}")
    int deleteUser(int userid);

    @Select("select * from user where id=#{id}")
    User findOneUserById(int userid);
}
