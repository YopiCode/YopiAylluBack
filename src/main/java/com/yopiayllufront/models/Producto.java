package com.yopiayllufront.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Data
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false,length = 50)
    private String nombre;
    @Column(nullable = false)
    private Date fecha_caducidad;
    @Column(nullable = false)
    private boolean caducable;
    @Column(nullable = false,length = 50)
    private boolean disponible;

}
