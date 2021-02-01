package com.yueguang.model.dao;

import com.yueguang.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements IUserDao {

    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }

    public List<User> findAll() {
        SqlSession session = factory.openSession();
        List<User> users = session.selectList("com.yueguang.model.dao.IUserDao.findAll");
        session.close();
        return users;
    }

    public void saveUser(User user) {
        SqlSession session = factory.openSession();
        session.insert("com.yueguang.model.dao.IUserDao.saveUser",user);
        session.commit();
        session.close();
    }

    public void updateUser(User user) {
        SqlSession session = factory.openSession();
        session.update("com.yueguang.model.dao.IUserDao.updateUser",user);
        //session.commit();
        session.close();
    }

    public int deleteUser(int userid) {
        SqlSession session = factory.openSession();
        session.delete("com.yueguang.model.dao.IUserDao.deleteUser",userid);
        return userid;
    }

    public User findOneUserById(int userid) {
        SqlSession session = factory.openSession();
        User user =session.selectOne("com.yueguang.model.dao.IUserDao.findOneUserById",userid);
        return user;
    }

}
