package com.cagdasalagoz.authservice.repository;

import com.cagdasalagoz.authservice.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.util.StringUtils;

public interface UserRepository extends MongoRepository<User, String> {

    User getUserByUsernameAndPassword(String username, String password);

    boolean deleteUserByUsername(String username);
}
