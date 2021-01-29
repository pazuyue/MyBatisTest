import com.yueguang.model.User;
import com.yueguang.model.dao.IUserDao;
import com.yueguang.model.dao.UserDaoImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybaitsTest {

    public void testFinal(){

    }
    public static void main(String[] args) throws IOException {
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        IUserDao userDao = new UserDaoImpl(factory);
        List<User> users = userDao.findAll();
        for (User user : users){
            System.out.println(user);
        }
        in.close();
    }
}
