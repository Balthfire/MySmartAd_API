package com.repositories;

import com.models.Place;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Menerith on 16/11/2016.
 */
public interface PlaceRepository extends CrudRepository<Place,Integer> {
}
