package com.swahed.tblrelation.tblrelation;

import com.swahed.tblrelation.tblrelation.dao.PostRepository;
import com.swahed.tblrelation.tblrelation.model.PostModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TblrelationApplication{

	@Autowired
	PostRepository postRepository;

	public static void main(String[] args) {
		SpringApplication.run(TblrelationApplication.class, args);

	}
}
