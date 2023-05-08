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
public class Familias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 20)
    @NotBlank(message = "El nombre de la Familia no puede quedar en blanco")
    private String nombrefamilia;

    @Column(nullable = false, unique = true)
    @NotNull
    @Min(value = 1000, message = "El codigo debe ser de 4 digitos")
    @Max(value = 9999, message = "El codigo debe ser de 4 digitos")
    private Integer codigofamiliar;

    @Column(nullable = false)
    @NotBlank(message = "La contraseña no debe estar vacia")
    private String contrasena;

    @Column(nullable = false, length = 50)
    @NotBlank(message = "Por favor escriba una Direccion")
    private String direccion;

    public Familias(Integer codigofamiliar) {
        this.codigofamiliar = codigofamiliar;
    }

    public Familias(Integer codigofamiliar, String contrasena) {
        this.codigofamiliar = codigofamiliar;
        this.contrasena = contrasena;
    }
}
