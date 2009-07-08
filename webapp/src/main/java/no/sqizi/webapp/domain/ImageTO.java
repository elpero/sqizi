package no.sqizi.webapp.domain;

/**
 * Created by IntelliJ IDEA.
 * User: SG0206005
 * Date: Jun 28, 2009
 * Time: 1:03:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class ImageTO {

    private Long articleId;
    private Long imageId;
    private String imageDescription;
    private String imageName;
    private String imageType;
    private String imagePath;
    private String thumbnailPath;


    public String getImageDescription() {
        return imageDescription;
    }

    public void setImageDescription(String imageDescription) {
        this.imageDescription = imageDescription;
    }

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getThumbnailPath() {
        return thumbnailPath;
    }

    public void setThumbnailPath(String thumbnailPath) {
        this.thumbnailPath = thumbnailPath;
    }
}
