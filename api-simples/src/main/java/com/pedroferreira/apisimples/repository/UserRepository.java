package com.pedroferreira.apisimples.repository;

import com.pedroferreira.apisimples.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findById(Long id);
    void deleteById(Long id);
}
