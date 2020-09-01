package com.dxctraining.mongoexperiments.suppliermgt.service;

import com.dxctraining.mongoexperiments.suppliermgt.entities.*;

import com.dxctraining.mongoexperiments.suppliermgt.exceptions.*;
import com.dxctraining.mongoexperiments.suppliermgt.dao.ISupplierDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierServiceImpl implements ISupplierService{
	

    @Autowired
    private MongoTemplate mongo;

    @Autowired
    private ISupplierDao dao;


    @Override
    public Supplier save(Supplier supplier) {
       supplier= dao.save(supplier);
       return supplier;
    }
    
    @Override
    public List<Supplier>findByName(String name){
        List<Supplier>list=dao.findByName(name);
        return list;
    }


    @Override
    public Supplier findById(String id) {
      Optional<Supplier>optional= dao.findById(id);
      boolean exist=optional.isPresent();
      if(!exist){
          throw new SupplierNotFoundException("supplier not found for id="+id);
      }
      Supplier supplier=optional.get();
       return supplier;
    }

    @Override
    public void removeById(String id) {
       dao.deleteById(id);
    }
}
