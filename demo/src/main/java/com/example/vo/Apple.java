package com.example.vo;

import com.example.annotion.Color;
import lombok.Data;

@Data
public class Apple {

    @Color(value = "red")
    private String name;

    private Double price;

}
