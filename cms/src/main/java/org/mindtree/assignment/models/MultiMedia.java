package org.mindtree.assignment.models;

import javax.persistence.*;

/**
 * Created by Neetesh Narvaria - M1038226 on 12/21/2016.
 */
@Entity
public class MultiMedia {
    private Long id;
    private String name;
    private byte[] data;
    private String contentType;

    @Id
    @GeneratedValue
    @Column(name = "IMAGE_ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Lob
    @Column(nullable = false)
    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @Column(nullable = false, length = 100)
    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
