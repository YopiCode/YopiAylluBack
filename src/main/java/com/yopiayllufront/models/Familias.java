package com.yopiayllufront.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Familias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 20)
    private String nombrefamilia;
    @Column(nullable = false, unique = true)
    private int codigofamiliar;
    @Column(nullable = false)
    private int contrasena;
    @Column(nullable = false, length = 50)
    private String direccion;

}
