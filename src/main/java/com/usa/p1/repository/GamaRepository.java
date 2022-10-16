package com.usa.p1.repository;

import com.usa.p1.model.Gama;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GamaRepository extends CrudRepository<Gama,Integer> {
}
