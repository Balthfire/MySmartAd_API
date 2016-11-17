package com.repositories;

import com.models.typePlace;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Menerith on 16/11/2016.
 */
@Transactional
public interface TypePlaceRepository  extends CrudRepository<typePlace, Integer>{

}
