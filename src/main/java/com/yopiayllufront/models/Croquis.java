package com.yopiayllufront.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Croquis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "idfamilia",nullable = false)
    private Familias familias;
    @Column(nullable = false)
    private byte mapa;
    @Column(nullable = false)
    private int piso;

}
