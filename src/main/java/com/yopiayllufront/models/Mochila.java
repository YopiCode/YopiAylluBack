package com.yopiayllufront.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Mochila {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "idproducto",nullable = false)
    private Producto producto;
    @ManyToOne
    @JoinColumn(name = "idfamilia",unique = true,nullable = false)
    private Familias familias;
}
