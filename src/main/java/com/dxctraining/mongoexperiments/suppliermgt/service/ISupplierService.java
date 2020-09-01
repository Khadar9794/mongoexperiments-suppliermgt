package com.dxctraining.mongoexperiments.suppliermgt.service;

import java.util.List;

import com.dxctraining.mongoexperiments.suppliermgt.entities.Supplier;

public interface ISupplierService {

    Supplier save(Supplier supplier);

    Supplier findById(String id);

    void removeById(String id);
    
    List<Supplier>findByName(String name);

	List<Supplier> findAll();

	List<Supplier> findByName1(String name);
	

	
	

}
