package com.yueguang.model.dao;

import com.yueguang.model.QueryVo;
import com.yueguang.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;

import java.util.List;

public class XUserDaoImpl implements IXUserDao {

    private  SqlSession session;

    public XUserDaoImpl(SqlSessionFactory factory) {
        this.session = factory.openSession(true);
    }



    @After
    public void destory()  {
        this.session.close();
    }

    public List<User> findAll() {
        IXUserDao ixUserDao =session.getMapper(IXUserDao.class);
        List<User> users =ixUserDao.findAll();
        return users;
    }

    public List<User> findRouleAll() {
        IXUserDao ixUserDao =session.getMapper(IXUserDao.class);
        List<User> users =ixUserDao.findRouleAll();
        return users;
    }

    public List<User> findUserByCondition(User user) {
        IXUserDao ixUserDao =session.getMapper(IXUserDao.class);
        List<User> users =ixUserDao.findUserByCondition(user);
        return users;
    }

    public List<User> findUserInIds(QueryVo queryVo) {
        IXUserDao ixUserDao =session.getMapper(IXUserDao.class);
        List<User> users =ixUserDao.findUserInIds(queryVo);
        return users;
    }

    public int saveUser(User user) {
        IXUserDao ixUserDao =session.getMapper(IXUserDao.class);
       int userid =ixUserDao.saveUser(user);
       return  userid;
    }


}
