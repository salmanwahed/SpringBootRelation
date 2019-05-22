package com.swahed.tblrelation.tblrelation.dao;

import com.swahed.tblrelation.tblrelation.model.PostModel;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<PostModel, Long>{
}
