package no.sqizi.flexclient.domain {

[RemoteClass(alias="no.sqizi.webapp.domain.ImageTO")]
[Bindable]
public class Image {
    public function Image() {
    }

    public var imageId:int;
    public var imagePath:String;
    public var thumbnailPath:String;
    public var articleId:int;
    public var imageDescription:String;
    public var imageType:String;
    public var imageName:String;

    
}
}