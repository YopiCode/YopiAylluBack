package com.yopiayllufront.models;

import jakarta.persistence.*;
import lombok.*;

@Entity @Setter @Getter @AllArgsConstructor @NoArgsConstructor @ToString
public class PasosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 40)
    private String paso;
    @ManyToOne
    @JoinColumn(name = "idplan", nullable = false)
    private PlanesModel planes;

}
