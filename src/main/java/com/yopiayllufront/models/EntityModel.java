package com.yopiayllufront.models;

import lombok.Data;

@Data
public class EntityModel<E> {
    private int codigofamiliar;
    private E model;


}
