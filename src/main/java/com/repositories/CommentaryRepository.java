package com.repositories;

import com.models.Commentary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Menerith on 16/11/2016.
 */
@Transactional
public interface CommentaryRepository extends CrudRepository<Commentary,Integer> {
}
