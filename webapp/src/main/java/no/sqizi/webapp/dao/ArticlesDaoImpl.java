package no.sqizi.webapp.dao;

import no.sqizi.webapp.domain.Article;
import no.sqizi.webapp.domain.ImageTO;
import no.sqizi.webapp.domain.User;
import no.sqizi.webapp.domain.ArticleThumbnail;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: SG0206005
 * Date: Jun 17, 2009
 * Time: 10:38:24 PM
 * To change this template use File | Settings | File Templates.
 */

@Repository
public class ArticlesDaoImpl implements ArticlesDao {

     @Autowired
    private SqlMapClientTemplate template;

    public SqlMapClientTemplate getTemplate() {
        return template;
    }

    public void setTemplate(SqlMapClientTemplate template) {
        this.template = template;
    }

    @Override
    public Article getArticle(Long id){
        return (Article) template.queryForObject("getArticle", id);
    }

    @Override
    public Long addArticle(String title, Long categoryId, String articleAbstract, String content, String author) {
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("title", title);
        params.put("author", author);
        params.put("categoryId", categoryId);
        params.put("abstract", articleAbstract);
        params.put("content", content);
        return (Long) template.insert("addArticle", params);
    }

    @Override
    public void addCategory(String name, String description, Long parent, String company){
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("name", name);
        params.put("description", description);
        params.put("parent", parent);
        params.put("company", company);
        template.insert("addCategory", params);

    }

    @Override
    public List<ImageTO> getArticleImageIds(Long articleId) {
        return template.queryForList("getArticleImageIds", articleId);
    }

    @Override
    public void updateArticle(Long id, String title, String articleAbstract, String content, User author, Date date) {
         HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        params.put("title", title);
        params.put("abstract",articleAbstract);
        params.put("content", content);
        params.put("userName", author==null?null:author.getUserName());
        params.put("date", date);
        template.update("updateArticle", params);
    }

    @Override
    public List<ArticleThumbnail> getRecentArticlesForCompany(int number, String companyName){
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("number", number);
        params.put("companyName", companyName);
        return template.queryForList("getRecentArticlesForCompany",params);
    }


}
