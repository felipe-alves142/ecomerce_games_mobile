package com.example.ecomercegamesmobile.src.controller;

import com.example.ecomercegamesmobile.src.dto.request.ProductDTO;
import com.example.ecomercegamesmobile.src.dto.response.MessageResponseDTO;
import com.example.ecomercegamesmobile.src.entity.Product;
import com.example.ecomercegamesmobile.src.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@SpringBootApplication
@RestController
@RequestMapping("/api/v1/product")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EcommerceController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public MessageResponseDTO createProduct(@RequestBody ProductDTO productDTO){
        return productService.createProduct(productDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<ProductDTO> listProduct(){
        return productService.listProduct();
    }
}
