package no.sqizi.webapp.domain;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: SG0206005
 * Date: Jun 17, 2009
 * Time: 10:08:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class ArticleCategory {

    private Long parentCategory = null;
    private Long id;
    private String name;
    private String description;
    List<ArticleThumbnail> articles;
    private String companyName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<ArticleThumbnail> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleThumbnail> articles) {
        this.articles = articles;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Long parentCategory) {
        this.parentCategory = parentCategory;
    }
}
