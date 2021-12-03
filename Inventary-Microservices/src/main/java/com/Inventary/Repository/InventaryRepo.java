package com.Inventary.Repository;



import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Inventary.Models.Inventary;



@Repository
public interface InventaryRepo extends MongoRepository<Inventary, Long>{

	

}
