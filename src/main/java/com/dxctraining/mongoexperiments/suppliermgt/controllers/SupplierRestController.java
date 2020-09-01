package com.dxctraining.mongoexperiments.suppliermgt.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dxctraining.mongoexperiments.suppliermgt.dto.CreateSupplierRequest;
import com.dxctraining.mongoexperiments.suppliermgt.dto.SupplierDto;
import com.dxctraining.mongoexperiments.suppliermgt.entities.Supplier;
import com.dxctraining.mongoexperiments.suppliermgt.service.ISupplierService;
import com.dxctraining.mongoexperiments.suppliermgt.util.SupplierUtil;

@RestController
@RequestMapping("/suppliers")
public class SupplierRestController {
	
	@Autowired
	private ISupplierService service;
	
	@Autowired
	private SupplierUtil util; 
	
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public SupplierDto addSupplier(@RequestBody CreateSupplierRequest requestData) {
		Supplier supplier = new Supplier(requestData.getName(), requestData.getPassword());
		supplier = service.save(supplier);
		SupplierDto response = util.supplierDto(supplier);
		return response;
	}
	
	@GetMapping("/get/{id}")
	@ResponseStatus(HttpStatus.OK)
	public SupplierDto findSupplierById(@PathVariable("id")String id) {
		Supplier supplier = service.findById(id);
		SupplierDto response = util.supplierDto(supplier);
		return response;
	}

}
