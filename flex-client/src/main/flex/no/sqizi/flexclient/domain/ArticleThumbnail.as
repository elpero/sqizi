package no.sqizi.flexclient.domain {

[RemoteClass(alias="no.sqizi.webapp.domain.ArticleThumbnail")]
[Bindable]
public class ArticleThumbnail {
    public function ArticleThumbnail() {
    }

    public var authorName:String;
    public var date:Date;
    public var id:int;
    public var title:String
}
}