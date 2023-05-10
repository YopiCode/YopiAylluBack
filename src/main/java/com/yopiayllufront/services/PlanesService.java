package com.yopiayllufront.services;

import com.yopiayllufront.models.Pasos;
import com.yopiayllufront.models.response.PasosResponse;
import com.yopiayllufront.models.response.PlanesResponse;
import com.yopiayllufront.repositories.PasosRepository;
import com.yopiayllufront.repositories.PlanesRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class PlanesService {
    @Autowired
    PlanesRespository planesRespository;
    @Autowired
    PasosRepository pasosRepository;

    public ResponseEntity<ArrayList<PlanesResponse>> getPlanes(int codigo) {
        ArrayList<PlanesResponse> response = (ArrayList<PlanesResponse>) planesRespository.findAllByFamilias_Codigofamiliar(codigo).stream().map(item -> {
            PlanesResponse planesResponse = new PlanesResponse();
            planesResponse.setId(item.getId());
            planesResponse.setNombre(item.getNombre());
            ArrayList<Pasos> pasos = pasosRepository.findAllByPlanes_Id(item.getId());
            planesResponse.setPasos((ArrayList<PasosResponse>) pasos.stream().map(paso -> {
                PasosResponse pasosResponse = new PasosResponse();
                pasosResponse.setId(paso.getId());
                pasosResponse.setDetalle(paso.getPaso());
                pasosResponse.setPaso(pasos.indexOf(paso) + 1);
                return pasosResponse;
            }).collect(Collectors.toList()));
            return planesResponse;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

}
