package no.sqizi.flexclient.domain {

[RemoteClass(alias="no.sqizi.webapp.domain.ImageTO")]
[Bindable]
public class Image {
    public function Image() {
    }

    public var imageId;
    public var imagePath;
    public var thumbnailPath;
    public var articleId;
    public var imageDescription;
    public var imageType;
    public var imageName;

    
}
}