package no.sqizi.webapp.flex.services;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import no.sqizi.webapp.dao.UserDao;

/**
 * Created by IntelliJ IDEA.
 * User: SG0206005
 * Date: Jun 17, 2009
 * Time: 7:54:29 AM
 * To change this template use File | Settings | File Templates.
 */

@RunWith(org.mockito.runners.MockitoJUnit44Runner.class)
public class LoginServiceImplTest {

    @Mock
    UserDao dao;

    LoginServiceImpl serv;

    @Before
    public void setUp(){

        serv = new LoginServiceImpl();
        serv.setUserDao(dao);

    }
    @Test
    public void testLogin() throws Exception {

        serv.getUser("aaa");
        verify(serv.getUserDao()).getUser("aaa");
        verifyNoMoreInteractions(serv.getUserDao());
    }
}
