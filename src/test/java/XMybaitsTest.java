
import com.yueguang.model.QueryVo;
import com.yueguang.model.User;
import com.yueguang.model.dao.IXUserDao;
import com.yueguang.model.dao.XUserDaoImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XMybaitsTest {
    private InputStream in;
    private IXUserDao iuserDao;
    private SqlSessionFactory factory;

    @Before
    public void init() throws IOException {
         in = Resources.getResourceAsStream("sqlMapConfig.xml");
         factory = new SqlSessionFactoryBuilder().build(in);
         iuserDao = new XUserDaoImpl(factory);

    }

    @After
    public void destory() throws IOException {
        in.close();
    }

    @Test
    public void testFindAll()  {
        List<User> users = iuserDao.findAll();
        for (User user : users){
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }

    @Test
    public void TestFindRouleAll(){
        List<User> users = iuserDao.findRouleAll();
        for (User user : users){
            System.out.println(user);
            System.out.println(user.getRoles());
        }
    }

    @Test
    public void saveUser(){
        User userone = new User();
        userone.setUsername("月光-One");
        userone.setAddress("广州");
        userone.setSex(1);
        userone.setBirthday(new Date());
        iuserDao.saveUser(userone);
        System.out.print("User.id()=" + userone.getId());
    }

    @Test
    public void testFindUserByCondition(){
        User u = new User();
        u.setSex(2);
        List<User> users = iuserDao.findUserByCondition(u);
        for (User user : users){
            System.out.println(user);
        }
    }

    @Test
    public void testFindUserInIds(){
        QueryVo queryVo = new QueryVo();
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        queryVo.setIds(list);
        List<User> users = iuserDao.findUserInIds(queryVo);
       for (User user : users){
           System.out.println(user);
       }
    }

    @Test
    public void TestfindById(){
        User user = iuserDao.findById(1);
        System.out.println(user);
    }


}
