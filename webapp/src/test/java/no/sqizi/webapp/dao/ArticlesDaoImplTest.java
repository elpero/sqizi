package no.sqizi.webapp.dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.util.HashMap;
import java.util.Date;

import no.sqizi.webapp.domain.User;

@RunWith(org.mockito.runners.MockitoJUnit44Runner.class)
public class ArticlesDaoImplTest {

    @Mock
    SqlMapClientTemplate template;

    private ArticlesDaoImpl articleDao;

    @Before
    public void setUp() throws Exception {
        articleDao = new ArticlesDaoImpl();
        articleDao.setTemplate(template);

    }

    @Test
    public void testGetArticle() throws Exception {
        articleDao.getArticle(1L);
        verify(template).queryForObject("getArticle",1L);
        verifyNoMoreInteractions(template);

    }

    @Test
    public void testAddArticle() {
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("title", "title");
        params.put("author", "author");
        params.put("categoryId", 1L);
        params.put("abstract", "aaa");
        params.put("content", "ccc");
        articleDao.addArticle("title", 1L, "aaa", "ccc", "author");
        verify(template).insert("addArticle", params);
        verifyNoMoreInteractions(template);
    }

    @Test
    public void testUpdateArticle(){
        final User author = new User();
        final String name = "name";
        author.setUserName(name);
        final Date date = new Date();
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("title", "title");
        params.put("id", 1L);
        params.put("userName", name);
        params.put("date", date);
        params.put("abstract", "aaa");
        params.put("content", "ccc");
        articleDao.updateArticle(1L, "title","aaa", "ccc", author, date);
        verify(articleDao.getTemplate()).update("updateArticle", params);
        verifyNoMoreInteractions(template);

    }
    
    @Test
    public void testAddCategory(){
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("name", "name");
        params.put("description", "description");
        params.put("parent", 1L);
        params.put("company", "company");
        articleDao.addCategory("name", "description", 1L, "company");
        verify(template).insert("addCategory", params);
        verifyNoMoreInteractions(template);
    }
    
    @Test
    public void testGetArticleImages(){
        articleDao.getArticleImageIds(1L);
        verify(template).queryForList("getArticleImageIds", 1L);
        verifyNoMoreInteractions(template);

    }

    @Test
    public void testGetRecentArticlesForCompany(){
        final String companyName = "yahoo";
        final int number = 5;
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("number", number);
        params.put("companyName", companyName);
        articleDao.getRecentArticlesForCompany(number, companyName);
        verify(template).queryForList(eq("getRecentArticlesForCompany"), eq(params));
        verifyNoMoreInteractions(template);

    }


}
