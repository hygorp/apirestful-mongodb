package com.hygorp.apirestfulmongodb.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.hygorp.apirestfulmongodb.domain.Post;
import com.hygorp.apirestfulmongodb.domain.User;
import com.hygorp.apirestfulmongodb.dto.AuthorDTO;
import com.hygorp.apirestfulmongodb.dto.CommentDTO;
import com.hygorp.apirestfulmongodb.repositories.PostRepository;
import com.hygorp.apirestfulmongodb.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, Instant.now(), "Hello World!", "My first post, hello!", new AuthorDTO(maria));
		Post post2 = new Post(null, Instant.now(), "Hello!", "My second post, hello!", new AuthorDTO(maria));
	
		CommentDTO comment1 = new CommentDTO("Nice!",Instant.now(), new AuthorDTO(alex));
		CommentDTO comment2 = new CommentDTO("Whoa!",Instant.now(), new AuthorDTO(bob));
		CommentDTO comment3 = new CommentDTO("More!!", Instant.now(), new AuthorDTO(alex));
		
		post1.getComments().addAll(Arrays.asList(comment1, comment2));
		post2.getComments().addAll(Arrays.asList(comment3));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
	
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
	}
}
