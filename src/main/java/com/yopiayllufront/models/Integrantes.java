package com.yopiayllufront.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Integrantes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "idfamilia",nullable = false)
    private Familias familias;
    @Column(nullable = false, length = 20)
    @NotNull
    @NotBlank(message = "El nombre no debe ser vacio")
    private String nombres;
    @Column(nullable = false, length = 20)
    @NotNull
    private String apellidos;
    @Column(nullable = false, unique = true)
    @NotNull
    @NotNull(message = "El dni no puede ser nulo")
    @Min(value = 10000000, message = "Debe de ingresar un dni de 8 digitos")
    @Max(value = 99999999, message = "Debe de ingresar un dni de 8 digitos")
    private Integer dni;
    @NotNull
    @Column(nullable = false)
    private Integer telefono;
    @NotNull
    @Column(nullable = false)
    private Boolean lider;
    @NotNull
    @Column(nullable = false)
    private Boolean discapacitado;
    @NotNull
    @Column(nullable = false)
    private Boolean mascota;
    @NotNull
    @Column(nullable = false)
    private String roles;

    public Integrantes(Integer dni) {
        this.dni = dni;
    }
}
