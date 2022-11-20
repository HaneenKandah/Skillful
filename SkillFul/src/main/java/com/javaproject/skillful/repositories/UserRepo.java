package com.javaproject.skillful.repositories;

import org.springframework.data.repository.CrudRepository;

import com.javaproject.skillful.models.User;

public interface UserRepo extends CrudRepository<User, Long>{

}
