
import com.yueguang.model.Role;
import com.yueguang.model.dao.IXRoleDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class RoleTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IXRoleDao roleDao;
    private SqlSessionFactory factory;

    @Before
    public void init() throws IOException {
         in = Resources.getResourceAsStream("sqlMapConfig.xml");
         factory = new SqlSessionFactoryBuilder().build(in);

        sqlSession = factory.openSession(true);
        roleDao = sqlSession.getMapper(IXRoleDao.class);

    }

    @After
    public void destory() throws IOException {
        sqlSession.close();
        in.close();
    }

    @Test
    public void testFindAll() throws IOException {
        List<Role> roles = roleDao.findAll();
        for (Role role : roles){
            System.out.println(role);
            System.out.println(role.getUsers());
        }
    }


}
