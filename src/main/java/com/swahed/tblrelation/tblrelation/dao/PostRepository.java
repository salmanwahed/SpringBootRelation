package com.swahed.tblrelation.tblrelation.dao;

import com.swahed.tblrelation.tblrelation.model.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostModel, Long> {
}
