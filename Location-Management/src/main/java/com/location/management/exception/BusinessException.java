package com.location.management.exception;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
public class BusinessException extends Exception{
    @Autowired
    private List<ErrorModel> errorList;

    public BusinessException(List<ErrorModel> errorList){
        this.errorList = errorList;
    }
}
