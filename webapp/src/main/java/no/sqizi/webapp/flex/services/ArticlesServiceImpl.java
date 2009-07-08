package no.sqizi.webapp.flex.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import no.sqizi.webapp.dao.ArticlesDao;
import no.sqizi.webapp.domain.Article;
import no.sqizi.webapp.domain.ImageTO;
import no.sqizi.webapp.domain.User;
import no.sqizi.webapp.support.PropertiesSupplier;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: SG0206005
 * Date: Jun 17, 2009
 * Time: 10:37:28 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ArticlesServiceImpl implements ArticleService {

    @Autowired
    private ArticlesDao articleDao;
     @Autowired
    private PropertiesSupplier appProps;

    public PropertiesSupplier getAppProps() {
        return appProps;
    }

    public void setAppProps(PropertiesSupplier appProps) {
        this.appProps = appProps;
    }

    @Override
    public ArticlesDao getArticleDao() {
        return articleDao;
    }

    public void setArticleDao(ArticlesDao articleDao) {
        this.articleDao = articleDao;
    }

    public Article getArticle(Long id){
        return articleDao.getArticle(id);
    }

    public Long addArticle(String title, Long categoryId, String articleAbstract, String content, String author){
        return articleDao.addArticle(title, categoryId, articleAbstract, content, author);

    }
    @Override
    public void addCategory(String name, String description, Long parent, String company){
        articleDao.addCategory(name, description, parent, company);
    }

    public List<ImageTO> getArticleImages(Long articleId){
        List<ImageTO> images = articleDao.getArticleImageIds(articleId);
        String imagesRoot = appProps.getProperty("images.root.url")+articleId;
        for (ImageTO i:images){
            i.setImagePath(String.format("%s/%s.%s",imagesRoot,i.getImageName(),i.getImageType()));
            i.setThumbnailPath(String.format("%s/%s_thumb.%s",imagesRoot,i.getImageName(),i.getImageType()));
        }
        return images;
    }

    public void updateArticle(Long id, String title, String articleAbstract, String content, User author, Date date){
        articleDao.updateArticle(id, title, articleAbstract, content, author, date);

    }
}
