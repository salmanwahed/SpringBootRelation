package com.swahed.tblrelation.tblrelation.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "post")
public class PostModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private Set<CommentModel> comments;

    @Override
    public String toString() {
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
    }

    public PostModel() {
    }

    public PostModel(String title, String description, Set<CommentModel> comments) {
        this.title = title;
        this.description = description;
        this.comments = comments;
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

    public Set<CommentModel> getComments() {
        return comments;
    }

    public void setComments(Set<CommentModel> comments) {
        this.comments = comments;
    }
}
