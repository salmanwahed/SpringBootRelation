package com.swahed.tblrelation.tblrelation.controller;

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
        return postRepo.save(model);
    }
}
