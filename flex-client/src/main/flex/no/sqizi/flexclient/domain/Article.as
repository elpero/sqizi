package no.sqizi.flexclient.domain {

[RemoteClass(alias="no.sqizi.webapp.domain.Article")]
[Bindable]
public class Article {
    public function Article() {
    }
    public var content:String;
    public var author:User;
    public var date:Date;
    public var id:int;
    public var categoryId:int;
    public var title:String
}
}