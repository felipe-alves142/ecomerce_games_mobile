package com.example.ecomercegamesmobile.src.dto.request;

import javax.persistence.Id;
import javax.validation.constraints.Size;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    @Id
    private Long id;

    @NotNull
    @Size(min=2,max=100)
    private String nome;

    @NotNull
    private BigDecimal price;

    @NotNull
    private short score;

    private String image;
}
