package com.dxctraining.mongoexperiments.suppliermgt.dao;


import com.dxctraining.mongoexperiments.suppliermgt.entities.Supplier;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ISupplierDao extends MongoRepository<Supplier, String> {
	
	List<Supplier> findByName(String name);
	
}
