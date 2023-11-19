package com.loki.integrationtestdemo.core.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(){
        super("Veri Bulunamadı");
    }
    public ResourceNotFoundException(String message){
        super(message);
    }
}
