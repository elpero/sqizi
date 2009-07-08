package no.sqizi.webapp.dao;

import no.sqizi.webapp.domain.Article;
import no.sqizi.webapp.domain.ImageTO;
import no.sqizi.webapp.domain.User;

import java.util.List;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: SG0206005
 * Date: Jun 17, 2009
 * Time: 10:39:32 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ArticlesDao {
    Article getArticle(Long id);

    Long addArticle(String title, Long categoryId, String articleAbstract, String content, String author);

    void addCategory(String name, String description, Long parent, String company);

    List<ImageTO> getArticleImageIds(Long articleId);

    void updateArticle(Long id, String title, String articleAbstract, String content, User author, Date date);
}
