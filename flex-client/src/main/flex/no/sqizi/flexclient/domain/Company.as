package no.sqizi.flexclient.domain {
import mx.collections.ArrayCollection;

[RemoteClass(alias="no.sqizi.webapp.domain.Company")]
[Bindable]
public class Company {
    public function Company() {
    }

    public var articleCategories:ArrayCollection;
    public var name:String;
    public var parentName:String;


    
    public function getCategoryTree():ArticleCategoryTree{
        var articleCategoryTree:ArticleCategoryTree = new ArticleCategoryTree(articleCategories);
        return articleCategoryTree;
    }

    public function getCategoryById(id:int):ArticleCategory{
        for each (var cat:ArticleCategory in articleCategories){
            if (cat.id == id) return cat;
        }
        return null;
    }
}

}