package com.yopiayllufront.models.response;

import com.yopiayllufront.models.IntegrantesModel;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class IntegrantesResponse {
    private int id;
    private String nombres;
    private String apellidos;
    private Integer dni;
    private Integer telefono;
    private Boolean lider;
    private Boolean discapacitado;
    private Boolean mascota;
    private String roles;

    public IntegrantesResponse(IntegrantesModel integrantes){
        this.id = integrantes.getId();
        this.nombres = integrantes.getNombres();
        this.apellidos = integrantes.getApellidos();
        this.dni = integrantes.getDni();
        this.telefono = integrantes.getTelefono();
        this.lider = integrantes.getLider();
        this.discapacitado = integrantes.getDiscapacitado();
        this.mascota = integrantes.getMascota();
        this.roles = integrantes.getRoles();
    }
}
