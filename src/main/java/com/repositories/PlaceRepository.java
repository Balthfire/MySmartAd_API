package com.repositories;

import com.models.Place;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Menerith on 16/11/2016.
 */
@Transactional
public interface PlaceRepository extends CrudRepository<Place,Integer> {
}
