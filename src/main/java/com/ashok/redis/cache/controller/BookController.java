package com.ashok.redis.cache.controller;

import java.util.Collection;
import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashok.redis.cache.entity.BookEntity;

@RestController
public class BookController {

	// HashOperations provide method to perform operations
	private HashOperations<String, Integer, BookEntity> opsForHash = null;
	
	public BookController(RedisTemplate<String, BookEntity> redisTemplate) {
		//<String, Integer, BookEntity> => <book tableName, id, entity>
		opsForHash = redisTemplate.opsForHash();
		}

	@PostMapping("/save")
	public ResponseEntity<String> addBook(@RequestBody BookEntity bookEntity) {
		opsForHash.put("books", bookEntity.getBookId(), bookEntity);
		return new ResponseEntity<>("Book saved successfully", HttpStatus.CREATED);
	}
	
	@GetMapping("/book/{bookId}")
	public ResponseEntity<BookEntity> getBook(@PathVariable("bookId") Integer bookId) {
		BookEntity bookEntity = opsForHash.get("books", bookId);
		return new ResponseEntity<>(bookEntity, HttpStatus.OK);
	}
	
	@GetMapping("/books")
	public ResponseEntity<Collection<BookEntity>> getAllBooks() {
		Map<Integer, BookEntity> entries = opsForHash.entries("books");
		return new ResponseEntity<>(entries.values(), HttpStatus.OK);
	} 
}
