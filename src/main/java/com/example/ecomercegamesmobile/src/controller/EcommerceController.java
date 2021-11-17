package com.example.ecomercegamesmobile.src.controller;

import com.example.ecomercegamesmobile.src.dto.request.ProductDTO;
import com.example.ecomercegamesmobile.src.dto.response.MessageResponseDTO;
import com.example.ecomercegamesmobile.src.exeption.ProductNotFoundExeption;
import com.example.ecomercegamesmobile.src.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@SpringBootApplication
@RestController
@RequestMapping("/api/v1/card")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EcommerceController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public MessageResponseDTO createProduct(@RequestBody ProductDTO productDTO){
        return productService.createProduct(productDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public MessageResponseDTO deleteProduct(@PathVariable Long id,ProductDTO productDTO) throws ProductNotFoundExeption {
        return productService.deleteProduct(productDTO,id);
    }

    @GetMapping("id/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public List<ProductDTO> listProduct(@PathVariable("id") long id) throws ProductNotFoundExeption {
        return productService.listProduct(id);
    }

    @GetMapping("/{filter}")
    @ResponseStatus(HttpStatus.FOUND)
    public List listByPrice(){
        return productService.listByPrice();
    }
}
