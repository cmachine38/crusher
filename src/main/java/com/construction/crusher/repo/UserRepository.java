package com.construction.crusher.repo;

import com.construction.crusher.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

    User findByUsername(String username);
}