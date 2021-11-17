package com.example.ecomercegamesmobile.src.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundExeption extends Exception{
   public ProductNotFoundExeption(long id){
        super("Product not found with id " + id);
    }

}
