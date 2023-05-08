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
    @NotBlank(message = "El apellido no debe ser vacio")
    private String apellidos;

    @Column(nullable = false, unique = true)
    @NotNull(message = "El dni no puede ser nulo")
    @Min(value = 10000000, message = "Debe de ingresar un dni de 8 digitos")
    @Max(value = 99999999, message = "Debe de ingresar un dni de 8 digitos")
    private Integer dni;

    @Column(nullable = false)
    @NotNull(message = "El campo del Numero no puede estar Vacio")
    @Min(value = 900000000, message = "Debe de ingresar un telefono de 9 digitos")
    @Max(value = 999999999, message = "Debe de ingresar un telefono de 9 digitos")
    private Integer telefono;

    @Column(nullable = false)
    private Boolean lider;

    @Column(nullable = false)
    @NotNull
    private Boolean discapacitado;

    @Column(nullable = false)
    @NotNull()
    private Boolean mascota;

    @Column(nullable = false)
    @NotBlank(message = "El compo de Roles no puede estar Vacio")
    private String roles;

    public Integrantes(Integer dni) {
        this.dni = dni;
    }
}
