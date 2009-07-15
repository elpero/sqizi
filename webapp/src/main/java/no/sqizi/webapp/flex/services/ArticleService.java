package no.sqizi.webapp.flex.services;

import no.sqizi.webapp.dao.ArticlesDao;
import no.sqizi.webapp.domain.ImageTO;
import no.sqizi.webapp.domain.User;
import no.sqizi.webapp.domain.ArticleThumbnail;

import java.util.List;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: SG0206005
 * Date: Jun 20, 2009
 * Time: 6:08:19 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ArticleService {
    ArticlesDao getArticleDao();

    Long addArticle(String title, Long categoryId, String articleAbstract, String content, String user);

    void addCategory(String name, String description, Long parent, String company);

    List<ImageTO> getArticleImages(Long articleId);

    void updateArticle(Long id, String title, String articleAbstract, String content, User author, Date date);

    List<ArticleThumbnail> getRecentArticlesForCompany(int number, String companyName);
}
