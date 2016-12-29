package org.mindtree.assignment.models;

import javax.persistence.*;
import java.sql.Blob;

/**
 * Created by Neetesh Narvaria - M1038226 on 12/21/2016.
 */
@Table(name = "blog")
@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @Column
    private String title;

    @Column
    private String blogContent;

    @OneToOne
    @JoinColumn(name="mediaId")
    private MultiMedia media;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    public MultiMedia getMedia() {
        return media;
    }

    public void setMedia(MultiMedia media) {
        this.media = media;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
