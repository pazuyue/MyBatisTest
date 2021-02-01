package com.yueguang.model.dao;

import com.yueguang.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;


import java.util.List;

public class UserDaoImpl implements IUserDao {

    private SqlSessionFactory factory;
    private  SqlSession session;

    public UserDaoImpl(SqlSessionFactory factory) {

        this.factory = factory;
        this.session = factory.openSession();
    }

    @After
    public void destory()  {
        this.session.close();
    }

    public List<User> findAll() {
        this.session = factory.openSession();
        List<User> users = session.selectList("com.yueguang.model.dao.IUserDao.findAll");
        return users;
    }

    public void saveUser(User user) {
        this.session.insert("com.yueguang.model.dao.IUserDao.saveUser",user);
    }

    public void updateUser(User user) {
        this.session.update("com.yueguang.model.dao.IUserDao.updateUser",user);
    }

    public int deleteUser(int userid) {
        this.session.delete("com.yueguang.model.dao.IUserDao.deleteUser",userid);
        return userid;
    }

    public User findOneUserById(int userid) {
        User user = this.session.selectOne("com.yueguang.model.dao.IUserDao.findOneUserById",userid);
        return user;
    }

}
