package no.sqizi.webapp.dao;

import no.sqizi.webapp.domain.ArticleImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * User: SG0206005
 * Date: Jun 24, 2009
 * Time: 8:28:07 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class ImageDaoImpl implements ImageDao {

    @Autowired
    SqlMapClientTemplate template;

    public SqlMapClientTemplate getTemplate() {
        return template;
    }

    public void setTemplate(SqlMapClientTemplate template) {
        this.template = template;
    }

    @Override
    public void saveArticleImage(ArticleImage i){
        template.insert("insertArticleImage",i);

    }

    @Override
    public void addArticleReferenceToImage(ArticleImage i) {
       template.insert("addArticleReferenceToImage",i);     
    }
}
