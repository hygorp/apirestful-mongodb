package com.hygorp.apirestfulmongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hygorp.apirestfulmongodb.domain.Post;


public interface PostRepository extends MongoRepository<Post, String>{
	
}
