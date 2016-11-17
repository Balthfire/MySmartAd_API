package com.repositories;

import com.models.Client;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Menerith on 16/11/2016.
 */
public interface ClientRepository extends CrudRepository<Client,Integer> {
}
