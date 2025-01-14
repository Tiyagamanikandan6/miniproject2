package com.app.repo;

import com.app.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableMongoRepositories
public interface UserRepo extends MongoRepository<User, String> {

	String findByEmail(String email);

	User findByEmailAndPassword(String email, String password);

}
