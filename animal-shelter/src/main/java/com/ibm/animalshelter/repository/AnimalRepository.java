package com.ibm.animalshelter.repository;

import com.ibm.animalshelter.model.collection.Animal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends MongoRepository<Animal, String> {
}
