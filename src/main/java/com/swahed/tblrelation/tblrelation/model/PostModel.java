package com.swahed.tblrelation.tblrelation.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "post")
public class PostModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String summary;

    @OneToOne(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private PostDetailModel postDetail;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<CommentModel> comments;


    public void setComments(Set<CommentModel> comments) {
        if (comments != null){
            for (CommentModel comment: comments){
                comment.setPost(this);
            }
        }
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public PostDetailModel getPostDetail() {
        return postDetail;
    }

    public void setPostDetail(PostDetailModel postDetail) {
        if (postDetail == null){
            if (this.postDetail != null){
                this.postDetail.setPost(null);
            }
        }else {
            postDetail.setPost(this);
        }
        this.postDetail = postDetail;
    }

    public Set<CommentModel> getComments() {
        return comments;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        if (comments != null){
            StringBuilder strComment = new StringBuilder();
            for (CommentModel commentModel: comments){
                strComment.append(commentModel.toString());
                strComment.append(" ");
            }
            if (postDetail != null)
                return "PostModel{" +
                        "id=" + id +
                        ", title='" + title + '\'' +
                        ", summary='" + summary + '\'' +
                        ", postDetail='" + postDetail.toString() + '\'' +
                        ", comments=" + strComment +
                        '}';
            else
                return "PostModel{" +
                        "id=" + id +
                        ", title='" + title + '\'' +
                        ", summary='" + summary + '\'' +
                        ", comments=" + strComment +
                        '}';
        }else {
            if (postDetail != null)
                return "PostModel{" +
                        "id=" + id +
                        ", title='" + title + '\'' +
                        ", summary='" + summary + '\'' +
                        ", postDetail='" + postDetail.toString() + '\'' +
                        '}';
            else
                return "PostModel{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", summary='" + summary;
        }
    }
}
