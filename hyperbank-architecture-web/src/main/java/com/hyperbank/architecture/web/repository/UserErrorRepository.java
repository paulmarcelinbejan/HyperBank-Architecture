package com.hyperbank.architecture.web.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hyperbank.architecture.web.documents.UserError;

@Repository
public interface UserErrorRepository extends MongoRepository<UserError, String>{
	
}
