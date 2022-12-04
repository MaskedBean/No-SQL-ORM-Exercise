package com.example.No.SQL.ORM.Exercise.repositories;

import com.example.No.SQL.ORM.Exercise.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
