package no.sqizi.webapp.dao;

import no.sqizi.webapp.domain.ArticleImage;

/**
 * Created by IntelliJ IDEA.
 * User: SG0206005
 * Date: Jun 24, 2009
 * Time: 8:39:36 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ImageDao {
    void saveArticleImage(ArticleImage i);

    void addArticleReferenceToImage(ArticleImage i);
}
