package ru.miphi.lab6;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
@Builder
@Getter
public class Item implements Serializable {
    private int id;
    private String description;
    private double cost;


}
