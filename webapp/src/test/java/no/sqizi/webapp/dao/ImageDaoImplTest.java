package no.sqizi.webapp.dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import no.sqizi.webapp.domain.ArticleImage;

/**
 * Created by IntelliJ IDEA.
 * User: SG0206005
 * Date: Jul 1, 2009
 * Time: 8:05:32 PM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(org.mockito.runners.MockitoJUnit44Runner.class)
public class ImageDaoImplTest {


    @Mock
    SqlMapClientTemplate template;

    ImageDaoImpl dao;


    @Before
    public void setUp() {
        dao = new ImageDaoImpl();
        dao.setTemplate(template);

    }

    @Test
    public void testSaveArticleImage() {
        final ArticleImage i = new ArticleImage("aaa.jpg", new byte[1024], 1L);
        dao.saveArticleImage(i);
        verify(template).insert("insertArticleImage", i);
        verifyNoMoreInteractions(template);
        // Add your code here
    }

    @Test
    public void testAddArticleReferenceToImage() {
        final ArticleImage i = new ArticleImage("aaa.png", new byte[1024], 1L);
        dao.addArticleReferenceToImage(i);
        verify(dao.getTemplate()).insert("addArticleReferenceToImage", i);
        verifyNoMoreInteractions(template);
    }
}
