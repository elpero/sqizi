package no.sqizi.webapp.dao;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: SG0206005
 * Date: Jun 17, 2009
 * Time: 6:27:27 AM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(org.mockito.runners.MockitoJUnit44Runner.class)
public class UserDaoImplTest {

    @Mock
    SqlMapClientTemplate template;

    UserDaoImpl dao;

    @Before
    public void setUp(){
        dao = new UserDaoImpl();
        dao.setTemplate(template);
    }

    @Test
    public void testLogin() throws Exception {
        dao.getUser("aaa");
        HashMap params = new HashMap<String, String>();
        params.put("userName", "aaa");
        verify(dao.getTemplate()).queryForObject(eq("getUser"), eq(params));
    }
}
