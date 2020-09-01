package com.dxctraining.mongoexperiments.suppliermgt.exceptions;

public class SupplierNotFoundException extends RuntimeException{

    public SupplierNotFoundException(String msg){
        super(msg);
    }

}
