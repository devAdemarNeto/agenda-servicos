package com.neto.agendaservicos.domain.exception;

public class BusinessException extends  RuntimeException{
    public BusinessException(String message){
        super(message);
    }

}
