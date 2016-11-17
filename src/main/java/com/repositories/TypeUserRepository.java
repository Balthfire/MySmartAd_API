package com.repositories;

import com.models.Type_User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Menerith on 17/11/2016.
 */
@Transactional
public interface TypeUserRepository extends CrudRepository<Type_User,Integer>{
}
