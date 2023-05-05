package com.yopiayllufront.utils;

import lombok.Data;

@Data
public class EntityModel<E> {
    private int codigofamiliar;
    private E model;
}
