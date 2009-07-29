package no.sqizi.webapp.flex.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import no.sqizi.webapp.dao.ArticlesDao;
import no.sqizi.webapp.dao.ImageDao;
import no.sqizi.webapp.domain.Article;
import no.sqizi.webapp.domain.ImageTO;
import no.sqizi.webapp.domain.User;
import no.sqizi.webapp.domain.ArticleThumbnail;
import no.sqizi.webapp.support.PropertiesSupplier;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

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
    private ImageDao imageDao;

     @Autowired
    private PropertiesSupplier appProps;

    public PropertiesSupplier getAppProps() {
        return appProps;
    }

    public void setAppProps(PropertiesSupplier appProps) {
        this.appProps = appProps;
    }

    public ImageDao getImageDao() {
        return imageDao;
    }

    public void setImageDao(ImageDao imageDao) {
        this.imageDao = imageDao;
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
        String imageDir = appProps.getProperty("images.directory")+articleId;
        final File dir = new File(imageDir);
        if (!dir.exists()) {
            new File(imageDir).mkdirs();
        }
        for (ImageTO i:images){
            final File imageFile = new File(String.format("%s/%s.%s", imageDir, i.getImageName(), i.getImageType()));
            if(!imageFile.exists()){
                try {
                    imageFile.createNewFile();
                    FileOutputStream fos = new FileOutputStream(imageFile);
                    final byte[] imageBytes = imageDao.getImageBytes(i.getImageId());
                    fos.write(imageBytes);
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        }

        return images;
    }

    public void updateArticle(Long id, String title, String articleAbstract, String content, User author, Date date){
        articleDao.updateArticle(id, title, articleAbstract, content, author, date);

    }

    @Override
    public List<ArticleThumbnail> getRecentArticlesForCompany(int number, String companyName){
        return articleDao.getRecentArticlesForCompany(number, companyName);

    }

    @Override
    public void deleteImage(Long imageId){
        imageDao.deleteImage(imageId); 
    }

}
