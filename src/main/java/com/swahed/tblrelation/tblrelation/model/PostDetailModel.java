package com.swahed.tblrelation.tblrelation.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.persistence.*;
import javax.sql.rowset.serial.SerialBlob;
import javax.validation.constraints.NotNull;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Date;

@Entity
@Table(name = "post_detail")
public class PostDetailModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String description;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date createdAt;

    @NotNull
    private String createdBy;

    @NotNull
    @Lob
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Blob photo;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    @JsonBackReference
    private PostModel post;

    public String getDescription() {
        return description;
    }


    public PostDetailModel() {
        this.createdAt = new Date();
    }

    public void setPhoto(String photoStr64) {
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("Photo: "+ photoStr64);
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        Blob blobData = null;
        if(photoStr64 != null) {
            byte[] dataByte = Base64.decodeBase64(photoStr64);
            try {
                blobData = new SerialBlob(dataByte);
            } catch (SQLException e) {
                System.out.println("########################################");
                System.out.println(e.getMessage());
                System.out.println("########################################");
            }
        }
        this.photo = blobData;
    }

    @Override
    public String toString() {
        return "PostDetailModel{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", createdBy='" + createdBy + '\'' +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public PostModel getPost() {
        return post;
    }

    public void setPost(PostModel post) {
        this.post = post;
    }
}
