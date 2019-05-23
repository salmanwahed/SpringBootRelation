package com.swahed.tblrelation.tblrelation.controller;

import com.swahed.tblrelation.tblrelation.dao.CommentRepository;
import com.swahed.tblrelation.tblrelation.dao.PostRepository;
import com.swahed.tblrelation.tblrelation.model.CommentModel;
import com.swahed.tblrelation.tblrelation.model.PostModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class CommentController {
    @Autowired
    CommentRepository commentRepo;

    @Autowired
    PostRepository postRepo;

    @GetMapping("/{postId}/comments")
    List<CommentModel> getAllComments(@PathVariable Long postId){
        return commentRepo.findByPostId(postId);
    }

    @PostMapping("/{postId}/comment")
    CommentModel createComment(@PathVariable Long postId, @Valid @RequestBody CommentModel comment){
        Optional<PostModel> optional = postRepo.findById(postId);
        if (optional.isPresent()){
            comment.setPost(optional.get());
            return commentRepo.save(comment);
        }else {
            return null;
        }
    }

    @GetMapping("/{postId}/comment/{commentId}")
    Optional<CommentModel> getComment(@PathVariable Long postId, @PathVariable Long commentId){
        return commentRepo.findById(commentId);
    }
}
