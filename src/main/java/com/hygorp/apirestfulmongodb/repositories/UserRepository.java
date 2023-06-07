package com.hygorp.apirestfulmongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hygorp.apirestfulmongodb.domain.User;


public interface UserRepository extends MongoRepository<User, String>{
	
}
