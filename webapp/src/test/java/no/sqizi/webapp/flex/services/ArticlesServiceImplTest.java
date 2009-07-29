package no.sqizi.webapp.flex.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.hamcrest.core.IsAnything.any;
import no.sqizi.webapp.dao.ArticlesDao;
import no.sqizi.webapp.dao.ImageDao;
import no.sqizi.webapp.domain.ImageTO;
import no.sqizi.webapp.domain.User;
import no.sqizi.webapp.support.PropertiesSupplier;

import java.util.Arrays;
import java.util.List;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: SG0206005
 * Date: Jun 20, 2009
 * Time: 7:59:25 PM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(org.mockito.runners.MockitoJUnit44Runner.class)
public class ArticlesServiceImplTest {

    @Mock
    ArticlesDao dao;
    @Mock
    ImageDao imageDao;

    @Mock
    PropertiesSupplier appProps;

    ArticlesServiceImpl serv;

    @Before
    public void setUp() throws Exception {
        serv = new ArticlesServiceImpl();
        serv.setArticleDao(dao);
        serv.setImageDao(imageDao);
        serv.setAppProps(appProps);
    }


    @Test
    public void testGetArticle() throws Exception {
        serv.getArticle(1L);
        verify(dao).getArticle(1L);
        verifyNoMoreInteractions(dao);
    }

    @Test
    public void testAddArticle() throws Exception {
        serv.addArticle("title", 1L, "aaa", "bbb", "tomek");
        verify(serv.getArticleDao()).addArticle("title", 1L, "aaa", "bbb", "tomek");
        verifyNoMoreInteractions(dao);
    }

    @Test
    public void testAddCategory() throws Exception {
        serv.addCategory("title", "aaa", 1L, "bbb");
        verify(dao).addCategory("title", "aaa", 1L, "bbb");
        verifyNoMoreInteractions(dao);
    }

    @Test
    public void testGetArticleImages(){

        final long articleId = 1L;
        final ImageTO imageTO1 = new ImageTO();
        imageTO1.setArticleId(articleId);
        imageTO1.setImageName("one");
        imageTO1.setImageType("jpg");
        final ImageTO imageTO2 = new ImageTO();
        imageTO2.setArticleId(articleId);
        imageTO2.setImageName("two");
        imageTO2.setImageType("png");
        final String imagesRoot = "/images/";
        when(serv.getAppProps().getProperty("images.root.url")).thenReturn(imagesRoot);
        when(dao.getArticleImageIds(articleId)).thenReturn(Arrays.asList(imageTO1, imageTO2));
        when(imageDao.getImageBytes(isA(Long.class))).thenReturn(new byte[0]);
        List<ImageTO> list= serv.getArticleImages(articleId);
        Assert.assertEquals("/images/1/one.jpg",list.get(0).getImagePath());
        Assert.assertEquals("/images/1/two.png",list.get(1).getImagePath());

    }

    @Test
    public void testUpdateArticle(){
        final Date date = new Date();
        final User author = new User();
        serv.updateArticle(1L,"title","abstract", "content", author, date);
        verify(serv.getArticleDao()).updateArticle(1L, "title","abstract","content", author, date);
        verifyNoMoreInteractions(serv.getArticleDao());
    }

    @Test
    public void testDeleteImage(){
        final Long imageId = 1L;
        serv.deleteImage(imageId);
        verify(imageDao).deleteImage(imageId);
        verifyNoMoreInteractions(imageDao);
    }
    

    @Test
    public void testGetRecentArticlesForCompany(){
        final int number  = 5;
        final String companyName = "yahoo.com";
        serv.getRecentArticlesForCompany(number, companyName);
        verify(serv.getArticleDao()).getRecentArticlesForCompany(number,companyName);
        verifyNoMoreInteractions(serv.getArticleDao());
    }





}
