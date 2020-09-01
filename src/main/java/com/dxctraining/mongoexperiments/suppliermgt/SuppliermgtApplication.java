package com.dxctraining.mongoexperiments.suppliermgt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.client.MongoClient;

@SpringBootApplication
@EnableMongoRepositories
public class SuppliermgtApplication {
	
	@Value("${spring.data.mongodb.database}")
	private String databaseName;

	
	public static void main(String[] args) {
		SpringApplication.run(SuppliermgtApplication.class, args);

	}
	
	@Bean
	public MongoTemplate mongoTemplate(MongoClient client){
		MongoTemplate template=new MongoTemplate(client,databaseName);
		return template;
	}

	

}
