package no.sqizi.webapp.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import no.sqizi.webapp.domain.ArticleImage;
import no.sqizi.webapp.dao.ImageDao;
import no.sqizi.webapp.support.PropertiesSupplier;

import java.io.File;
import java.io.IOException;
import java.io.FileOutputStream;

/**
 * Created by IntelliJ IDEA.
 * User: SG0206005
 * Date: Jun 24, 2009
 * Time: 8:59:56 AM
 * To change this template use File | Settings | File Templates.
 */

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageDao imageDao;

    @Autowired
    PropertiesSupplier appProps;

    public PropertiesSupplier getAppProps() {
        return appProps;
    }

    public void setAppProps(PropertiesSupplier appProps) {
        this.appProps = appProps;
    }


    public ImageDao getArticleDao() {
        return imageDao;
    }

    public void setArticleDao(ImageDao imageDao) {
        this.imageDao = imageDao;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE)
    public synchronized void saveArticleImage(ArticleImage i) {
        saveToDb(i);
        try {
            saveToFileSystem(i);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }


    private void saveToFileSystem(ArticleImage i) throws IOException {
        String imagePath = appProps.getProperty("images.directory");
        File dir = new File(imagePath+i.getArticleId());
        if (!dir.exists()) {
            dir.mkdir();
        }
        if (!dir.isDirectory()) {
            throw new IOException("Directory couldn't be created!");
        }

        File f = new File(dir, i.getFullFileName());
        f.createNewFile();
        FileOutputStream s = new FileOutputStream(f);
        s.write(i.getImageBytes());
        s.flush();s.close();

        File fthumb = new File(dir, i.getName()+"_thumb."+i.getType());
        fthumb.createNewFile();
        s = new FileOutputStream(fthumb);
        s.write(i.getThumbnail());
        s.flush();s.close();
        
    }

    private void saveToDb(ArticleImage i) {
        imageDao.saveArticleImage(i);
        imageDao.addArticleReferenceToImage(i);

    }

}
