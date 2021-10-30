package com.example.ecomercegamesmobile.src;

import com.example.ecomercegamesmobile.src.dto.request.ProductDTO;
import com.example.ecomercegamesmobile.src.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel="spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDTO toDTO(Product dto);

    Product toModel(ProductDTO dto);
}
