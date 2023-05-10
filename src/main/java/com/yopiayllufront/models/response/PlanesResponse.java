package com.yopiayllufront.models.response;

import lombok.*;

import java.util.ArrayList;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PlanesResponse {
    private int id;
    private String nombre;
    private ArrayList<PasosResponse> pasos;
}
