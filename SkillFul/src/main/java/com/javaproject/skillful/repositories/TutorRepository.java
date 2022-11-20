package com.javaproject.skillful.repositories;

import org.springframework.data.repository.CrudRepository;

import com.javaproject.skillful.models.Tutor;

public interface TutorRepository extends CrudRepository<Tutor, Long> {
    Tutor findByEmail(String email);
    Tutor findByUsername(String username);
}
