package no.sqizi.webapp.domain;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: SG0206005
 * Date: Jun 17, 2009
 * Time: 9:27:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class ArticleThumbnail {
    private Long id;
    private String title;
    private Date date;
    private String authorName;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
