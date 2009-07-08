package no.sqizi.webapp.dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

/**
 * Created by IntelliJ IDEA.
 * User: SG0206005
 * Date: Jun 18, 2009
 * Time: 8:03:51 AM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(org.mockito.runners.MockitoJUnit44Runner.class)
public class CompanyDaoImplTest {

    @Mock
    SqlMapClientTemplate template;

    CompanyDaoImpl dao;

    @Before
    public void setUp() throws Exception {
        dao = new CompanyDaoImpl();
        dao.setTemplate(template);

    }

    @Test
    public void testGetCompanyData() throws Exception {
        String name = "test";
        dao.getCompanyData(name);
        verify(dao.getTemplate()).queryForObject("getCompanyData",name);
        verifyNoMoreInteractions(template);

    }
}
