package no.sqizi.flexclient.domain {
import mx.collections.ArrayCollection;

[Bindable]
public class ArticleCategoryTreeElement  extends ArticleCategory{
    public function ArticleCategoryTreeElement(category:ArticleCategory) {
        super();
        this.companyName = category.companyName;
        this.name = category.name;
        this.articles = category.articles;
        this.description = category.description;
        this.id = category.id;
        this.parentCategory = category.parentCategory;
    }
    public var parent:ArticleCategoryTreeElement = null;
    public var children:ArrayCollection = new ArrayCollection();
}
}