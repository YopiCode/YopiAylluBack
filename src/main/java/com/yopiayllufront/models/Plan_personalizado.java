package com.yopiayllufront.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Plan_personalizado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "idfamilia",nullable = false)
    private Familias familias;
    @Column(nullable = false,length = 400)
    @NotBlank(message = "Por compo de Plan no puede ser vacio")
    private String plan;
}
