package com.ashok.redis.cache.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.ashok.redis.cache.entity.BookEntity;

@Configuration
public class RedisConfig {

	//provide connection server
	@Bean
	public JedisConnectionFactory jedisConnectionFactory() {
		JedisConnectionFactory jcf = new JedisConnectionFactory();
		return jcf;
	}
	
	//to perform operations
	@Bean
	public RedisTemplate<String, BookEntity> redisTemplate() {
		RedisTemplate<String, BookEntity> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
	}
}
