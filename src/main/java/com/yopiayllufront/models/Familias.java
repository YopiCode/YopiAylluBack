package com.yopiayllufront.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @NotNull
    private String nombrefamilia;
    @Column(nullable = false, unique = true)
    @NotNull
    @Size(min = 4, max = 4, message = "El codigo debe ser de 4 digitos")
    private Integer codigofamiliar;
    @Column(nullable = false)
    @NotNull
    private Integer contrasena;
    @Column(nullable = false, length = 50)
    @NotNull
    private String direccion;

    public Familias(Integer codigofamiliar) {
        this.codigofamiliar = codigofamiliar;
    }

    public Familias(Integer codigofamiliar, Integer contrasena) {
        this.codigofamiliar = codigofamiliar;
        this.contrasena = contrasena;
    }
}
