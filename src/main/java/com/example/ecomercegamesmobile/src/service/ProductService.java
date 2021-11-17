package com.example.ecomercegamesmobile.src.service;


import com.example.ecomercegamesmobile.src.ProductMapper;
import com.example.ecomercegamesmobile.src.dto.request.ProductDTO;
import com.example.ecomercegamesmobile.src.dto.response.MessageResponseDTO;
import com.example.ecomercegamesmobile.src.entity.Product;
import com.example.ecomercegamesmobile.src.exeption.ProductNotFoundExeption;
import com.example.ecomercegamesmobile.src.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class ProductService {

    private ProductRepository productRepository;


    private final ProductMapper productMapper = ProductMapper.INSTANCE;

    public MessageResponseDTO createProduct(@Valid ProductDTO productDTO){
        Product savedToProduct = productMapper.toModel(productDTO);
        Product savedProduct = productRepository.save(savedToProduct);

        MessageResponseDTO messageResponse = responseMessage("Created person with id", savedProduct.getId());

        return messageResponse;
    }


    //Method that find all products
    public List listProduct(Long id) throws ProductNotFoundExeption {
        verifyIfExists(id);
        List<Product> allProducts = productRepository.findAll();
        return allProducts
                .stream()
                .map(productMapper::toDTO)
                .collect(Collectors.toList());
    }

    //Method that delete all products
    public MessageResponseDTO deleteProduct(ProductDTO productDTO,Long id) throws ProductNotFoundExeption{
        verifyIfExists(id);
        productRepository.deleteById(id);

        MessageResponseDTO responseMessage = responseMessage("Product deleted with id ", productDTO.getId());

        return responseMessage;
    }


    public List listByPrice() {
        List<Product> searchResults = productRepository.findAll();
        return searchResults.stream()
                .map(productMapper::toDTO)
                .sorted((o1, o2) -> o1.getPrice().compareTo(o2.getPrice()))
                .collect(Collectors.toList());
    }
    private MessageResponseDTO responseMessage(String msg , Long id){
        return MessageResponseDTO
                .builder()
                .message(msg + id)
                .build();
    }

    private Product verifyIfExists(Long id) throws ProductNotFoundExeption {
        Product product = productRepository.findById(id).
                orElseThrow(()-> new ProductNotFoundExeption(id));

        return product;
    }

}
