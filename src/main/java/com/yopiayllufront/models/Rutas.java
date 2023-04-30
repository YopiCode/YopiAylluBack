package com.yopiayllufront.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Rutas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "idfamilia",nullable = false)
    private Familias familias;
    @Column(nullable = false,length = 200)
    private String nombre;
    @Column(nullable = false, length = 200)
    private String detalle;
    @Column(nullable = false,length = 50)
    private String tipo;

}
