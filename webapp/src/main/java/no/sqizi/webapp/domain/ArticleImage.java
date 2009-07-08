package no.sqizi.webapp.domain;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

import javax.imageio.ImageIO;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ByteArrayInputStream;

/**
 * Created by IntelliJ IDEA.
 * User: SG0206005
 * Date: Jun 24, 2009
 * Time: 8:44:05 AM
 * To change this template use File | Settings | File Templates.
 */
public class ArticleImage {

    private Long id;
    private static final int THUMBNAIL_SIZE = 120;
    private byte[] imageBytes;
    private String fullFileName;
    private String description;
    private Long articleId;
    private String name;
    private String type;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getFullFileName() {
        return fullFileName;
    }

    public void setFullFileName(String fullFileName) {
        this.fullFileName = fullFileName;
    }

    public byte[] getImageBytes() {
        return imageBytes;
    }

    public void setImageBytes(byte[] imageBytes) {
        this.imageBytes = imageBytes;
    }

    public ArticleImage(String name, byte[] imageBytes, Long articleId) {
        this.imageBytes = Arrays.copyOf(imageBytes, imageBytes.length);
        this.articleId = articleId;
        StringTokenizer tokenizer = new StringTokenizer(name, ".");
        this.name = tokenizer.nextToken();
        this.type = tokenizer.nextToken().toLowerCase();
        this.fullFileName = this.name + "." + type;

    }


    @Override
    public int hashCode() {
        HashCodeBuilder b = new HashCodeBuilder();
        return b.append(fullFileName).append(imageBytes).append(articleId)
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ArticleImage)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ArticleImage rhs = (ArticleImage) obj;
        EqualsBuilder builder = new EqualsBuilder();
        return builder.append(this.fullFileName, rhs.fullFileName).append(this.imageBytes,
                rhs.imageBytes).append(this.articleId, rhs.articleId)
                .isEquals();
    }

    public byte[] getThumbnail() {
        BufferedImage image = getImageFromBytes();
        int imageWidth = image.getWidth(null);
        int imageHeight = image.getHeight(null);
        double ratio = calculateScalingRatio(imageWidth, imageHeight);
        int thumbHeight = (int) (imageHeight / ratio);
        int thumbWidth = (int) (imageWidth / ratio);

        BufferedImage thumb = new BufferedImage(thumbWidth, thumbHeight, getImageType(image));
        Graphics2D g2 = null;
        g2 = thumb.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(image, 0, 0, thumbWidth, thumbHeight, 0, 0, imageWidth, imageHeight, null);
        g2.dispose();
        return getBytesFromImage(thumb);
    }

    public byte[] getBytesFromImage(BufferedImage thumb) {
        ByteArrayOutputStream thumbOS = new ByteArrayOutputStream();
        try {
            ImageIO.write(thumb, type, thumbOS);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] thumbBytes = thumbOS.toByteArray();
        return thumbBytes;
    }

    public BufferedImage getImageFromBytes() {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new ByteArrayInputStream(imageBytes));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    public int getImageType(BufferedImage image) {
        return (image.getTransparency() == Transparency.OPAQUE) ?
                BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
    }

    private double calculateScalingRatio(int imageWidth, int imageHeight) {
        double ratio = 1;
        if ((imageWidth > THUMBNAIL_SIZE) || (imageHeight > THUMBNAIL_SIZE)) {
            //choose bigger
            int width = (imageHeight > imageWidth) ? imageHeight : imageWidth;
            ratio = (double) width / THUMBNAIL_SIZE;
        }

        return ratio;
    }
}