package no.sqizi.flexclient.delegate {
import mx.rpc.AsyncToken;
import mx.rpc.remoting.RemoteObject;

import no.sqizi.flexclient.domain.User;

public class ArticleDelegate {


    [Autowire(bean="articleService")]
    public var articleService:RemoteObject;

    public function ArticleDelegate() {
    }

    public function getArticle(id:int):AsyncToken{
        return articleService.getArticle(id); 
    }

    public function addArticle(title:String, categoryId:int, abstract:String, content:String, user:String):AsyncToken{
        return articleService.addArticle(title, categoryId, abstract, content, user);
    }

    public function addCategory(name:String, description:String, parent:int, company:String):AsyncToken{
        return articleService.addCategory(name, description, parent, company);
    }

    public function getArticleImages(id:int):AsyncToken{
        return articleService.getArticleImages(id);
    }


    public function updateArticle(id:int, title:String, abstract:String, content:String, author:no.sqizi.flexclient.domain.User, date:Date):AsyncToken {
        return articleService.updateArticle(id,title,abstract,content,author,date);
    }

    public function getRecentArticles(number:int, companyName:String):AsyncToken{
        return articleService.getRecentArticlesForCompany(number, companyName);
    }

    public function deleteImage(imageId:int):AsyncToken {
        return articleService.deleteImage(imageId);
    }
}
}