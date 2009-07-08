package no.sqizi.webapp.flex.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import no.sqizi.webapp.dao.CompanyDao;

/**
 * Created by IntelliJ IDEA.
 * User: SG0206005
 * Date: Jun 18, 2009
 * Time: 8:00:30 AM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(org.mockito.runners.MockitoJUnit44Runner.class)
public class CompanyServiceImplTest {

    @Mock
    CompanyDao companyDao;

    CompanyServiceImpl service;

    @Before
    public void setUp() throws Exception {
        service = new CompanyServiceImpl();
        service.setCompanyDao(companyDao);

    }

    @Test
    public void testGetCompanyData() throws Exception {
        String name = "test";
        service.getCompanyData(name);
        verify(service.getCompanyDao()).getCompanyData(name);
        verifyNoMoreInteractions(companyDao);
    }
}
