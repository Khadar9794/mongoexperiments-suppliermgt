package com.dxctraining.mongoexperiments.suppliermgt.util;

import org.springframework.stereotype.Component;


import com.dxctraining.mongoexperiments.suppliermgt.dto.SupplierDto;
import com.dxctraining.mongoexperiments.suppliermgt.entities.Supplier;

@Component
public class SupplierUtil {
	
	public SupplierDto supplierDto(Supplier supplier) {
		SupplierDto dto = new SupplierDto(supplier.getId(),supplier.getName(),supplier.getPassword());
		return dto;
	}

}
