package com.repositories;

import com.models.Commentary;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Menerith on 16/11/2016.
 */
public interface CommentaryRepository extends CrudRepository<Commentary,Integer> {
}
