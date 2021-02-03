package com.yueguang.model.dao;

import com.yueguang.model.QueryVo;
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

    /**
     * 根据条件查询
     * @return
     */
    @Select({
            "<script>" ,
            "SELECT * FROM user",
            "<where>",
            "<if test='username != null and username != \" \" '>",
            " and username=#{username}",
            "</if>",
            "<if test='sex != null and username != \" \" '>",
            " and sex=#{sex}",
            "</if>",
            "</where>",
            "</script>"
    })
    List<User> findUserByCondition(User user);

    @Select({
            "<script>" ,
            "SELECT * FROM user",
            "<where>",
                "<if test='ids != null and ids.size() >0 '>",
                    "<foreach collection='ids' open='and id in ( ' close=')' item='id' separator=','>",
                        "#{id}",
                    "</foreach>",
                "</if>",
            "</where>",
            "</script>"
    })
    List<User> findUserInIds(QueryVo queryVo);
}
