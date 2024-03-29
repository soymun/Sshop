package com.example.shop.DTO.TypeOfFood;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class TypeOfFoodCreateDto {

    private String name;

    private Long typeOfFoodId;
}
