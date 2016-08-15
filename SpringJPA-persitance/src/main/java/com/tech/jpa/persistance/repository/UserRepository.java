package com.tech.jpa.persistance.repository;

import com.tech.jpa.persistance.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by x074823 on 8/15/2016.
 */
public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String username);
}
