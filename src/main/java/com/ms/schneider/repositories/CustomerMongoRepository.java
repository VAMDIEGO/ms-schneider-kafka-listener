package com.ms.schneider.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ms.schneider.entity.CustomerMongoData;


public interface CustomerMongoRepository extends MongoRepository<CustomerMongoData, String> {

}
