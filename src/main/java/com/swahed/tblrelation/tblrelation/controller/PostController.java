package com.swahed.tblrelation.tblrelation.controller;

import com.swahed.tblrelation.tblrelation.dao.CommentRepository;
import com.swahed.tblrelation.tblrelation.dao.PostRepository;
import com.swahed.tblrelation.tblrelation.model.PostModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class PostController {
    @Autowired
    PostRepository postRepo;

    @Autowired
    CommentRepository commentRepo;

    @GetMapping("/posts")
    List<PostModel> getAllPosts(){
        return (List<PostModel>) postRepo.findAll();
    }

    @GetMapping("/post/{postId}")
    Optional<PostModel> getPost(@PathVariable Long postId){
        return postRepo.findById(postId);
    }

    @PostMapping("/post")
    PostModel createPost(@Valid @RequestBody PostModel model){
        System.out.println(model.toString());
//        Set<CommentModel> commentModelSet = new HashSet<>();
//        for (CommentModel comment: model.getComments()){
//            comment.setPost(postModel);
//            commentModelSet.add(commentRepo.save(comment));
//        }
//        postModel.setComments(commentModelSet);
        PostModel postModel =  postRepo.save(model);
        System.out.println("@@Printing saved post: " + postModel);
        return postModel;
    }
}
