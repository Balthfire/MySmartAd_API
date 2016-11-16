package com.repositories;

import com.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Menerith on 16-Nov-16.
 */
public interface UserRepository extends CrudRepository<User,Integer> {
    List<User> findByName(String name);
}
