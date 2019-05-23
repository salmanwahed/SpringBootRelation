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

    private String description;

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

    public Set<CommentModel> getComments() {
        return comments;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        if (comments != null){
            StringBuilder strComment = new StringBuilder();
            for (CommentModel commentModel: comments){
                strComment.append(commentModel.toString());
                strComment.append(" ");
            }
            return "PostModel{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", description='" + description + '\'' +
                    ", comments=" + strComment +
                    '}';
        }else {
            return "PostModel{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", description='" + description;
        }
    }
}
