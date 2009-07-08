package no.sqizi.flexclient.domain {
import mx.collections.ArrayCollection;

[RemoteClass(alias="no.sqizi.webapp.domain.ArticleCategory")]
[Bindable]
public class ArticleCategory {
    public function ArticleCategory() {
    }

    public var articles:ArrayCollection;
    public var companyName:String;
    public var name:String;
    public var description:String;
    public var parentCategory:int;
    public var id:int;
}
}