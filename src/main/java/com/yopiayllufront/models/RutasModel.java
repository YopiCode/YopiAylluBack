package com.yopiayllufront.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class RutasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "idfamilia",nullable = false)
    private FamiliasModel familias;

    @Column(nullable = false,length = 200)
    @NotBlank(message = "El nombre no puede estar Vacio")
    private String nombre;

    @Column(nullable = false, length = 200)
    @NotBlank(message = "El detalle de la Ruta no puede estar Vacio")
    private String detalle;

    @Column(nullable = false,length = 50)
    @NotBlank(message = "El tipo de ruta no puede estar en Blanco")
    private String tipo;

}
