import com.yueguang.model.User;
import com.yueguang.model.dao.IUserDao;
import com.yueguang.model.dao.UserDaoImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybaitsTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;
    private SqlSessionFactory factory;

    @Before
    public void init() throws IOException {
         in = Resources.getResourceAsStream("sqlMapConfig.xml");
         factory = new SqlSessionFactoryBuilder().build(in);
         userDao = new UserDaoImpl(factory);
    }

    @After
    public void destory() throws IOException {
        in.close();
    }

    @Test
    public void testFindAll() throws IOException {
        List<User> users = userDao.findAll();
        for (User user : users){
            System.out.println(user);
        }
    }

    @Test
    public void testSave() throws IOException {
        User userone = new User();
        userone.setUsername("月光-Two");
        userone.setAddress("广州");
        userone.setSex("1");
        userone.setBirthday(new Date());
        userDao.saveUser(userone);
        System.out.print("User.id()=" + userone.getId());
    }

    @Test
    public void updateUser(){
        User userone = new User();
        userone.setId(1);
        userone.setUsername("月光-One");
        userone.setAddress("广州");
        userone.setSex("1");
        userone.setBirthday(new Date());
        userDao.updateUser(userone);
    }

    @Test
    public void deleteUser(){
        int userid =userDao.deleteUser(5);
        System.out.println(userid);
    }

    @Test
    public void getOneUser(){
        User user = userDao.findOneUserById(1);
        System.out.println(user);
    }

}
