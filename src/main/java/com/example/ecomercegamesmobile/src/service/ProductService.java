package com.example.ecomercegamesmobile.src.service;

import com.example.ecomercegamesmobile.src.ProductMapper;
import com.example.ecomercegamesmobile.src.dto.request.ProductDTO;
import com.example.ecomercegamesmobile.src.dto.response.MessageResponseDTO;
import com.example.ecomercegamesmobile.src.entity.Product;
import com.example.ecomercegamesmobile.src.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
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

    public MessageResponseDTO responseMessage(String msg , Long id){
        return MessageResponseDTO
                .builder()
                .message(msg + id)
                .build();
    }

    public List<ProductDTO> listProduct(){
        List<Product> allPeople = productRepository.findAll();
        return allPeople
                .stream()
                .map(productMapper::toDTO)
                .collect(Collectors.toList());
    }
}
