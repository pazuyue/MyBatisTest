import com.yueguang.model.Account;
import com.yueguang.model.QueryVo;
import com.yueguang.model.User;
import com.yueguang.model.dao.IUserDao;
import com.yueguang.model.dao.IXAccountDao;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IXAccountDao accountDao;
    private SqlSessionFactory factory;

    @Before
    public void init() throws IOException {
         in = Resources.getResourceAsStream("sqlMapConfig.xml");
         factory = new SqlSessionFactoryBuilder().build(in);

        sqlSession = factory.openSession(true);
        accountDao = sqlSession.getMapper(IXAccountDao.class);

    }

    @After
    public void destory() throws IOException {
        sqlSession.close();
        in.close();
    }

    @Test
    public void testFindAll() throws IOException {
        List<Account> accounts = accountDao.findAll();
       /* for (Account account : accounts){
            System.out.println(account);
            //System.out.println(account.getUser());
        }*/
    }


}
