package com.ibm.animalshelter.repository;

import com.ibm.animalshelter.model.collection.Voluntario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoluntarioRepository extends MongoRepository<Voluntario, String> {
}
