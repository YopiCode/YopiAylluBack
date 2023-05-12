package com.yopiayllufront.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.sql.Date;

@Entity
@Data
public class ProductoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "idfamilia",nullable = false)
    private FamiliasModel familias;

    @Column(nullable = false,length = 50)
    @NotBlank(message = "El nombre no puede estar vacio")
    private String nombre;

    @Column(nullable = true)
    private Date fecha_caducidad;

    @Column(nullable = false)
    private boolean caducable;

    @Column(nullable = false,length = 50)
    private boolean disponible;

}
