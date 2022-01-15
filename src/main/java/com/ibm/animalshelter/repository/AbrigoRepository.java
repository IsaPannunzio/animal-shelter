package com.ibm.animalshelter.repository;

import com.ibm.animalshelter.model.collection.Abrigo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbrigoRepository extends MongoRepository<Abrigo, String> {
}
