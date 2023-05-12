package com.yopiayllufront.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class CroquisModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "idfamilia",nullable = false)
    private FamiliasModel familias;
    @Lob
    @Column(nullable = false, columnDefinition = "LONGBLOB")
    private byte[] mapa;
    @Column(nullable = false)
    private int piso;

}
