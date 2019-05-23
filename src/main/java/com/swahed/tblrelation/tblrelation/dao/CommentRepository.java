package com.swahed.tblrelation.tblrelation.dao;

import com.swahed.tblrelation.tblrelation.model.CommentModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentModel, Long> {
    List<CommentModel> findByPostId(Long postId);
}
