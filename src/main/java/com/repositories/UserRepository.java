package com.repositories;

import com.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Menerith on 16-Nov-16.
 */
@Transactional
@Component
public interface UserRepository extends CrudRepository<User,Integer> {
    List<User> findByName(String name);
    User findByPseudo(String pseudo);
}
