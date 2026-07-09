package com.demo.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
@Data
@AllArgsConstructor
public class DemoProducts {

    private Integer productId;

    private String productName;
    private Double productPrice;
    private LocalDate releaseDate;
}
