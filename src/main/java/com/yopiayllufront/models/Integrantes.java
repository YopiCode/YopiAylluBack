package com.yopiayllufront.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Integrantes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "idfamilia")
    private Familias familias;
    @Column(nullable = false, length = 20)
    private String nombres;
    @Column(nullable = false, length = 20)
    private String apellidos;
    @Column(nullable = false)
    private int dni;
    @Column(nullable = false)
    private int telefono;
    @Column(nullable = false)
    private boolean lider;
    @Column(nullable = false)
    private boolean discapacitado;
    @Column(nullable = false)
    private boolean mascota;
}
