package com.yopiayllufront.services;

import com.yopiayllufront.models.Integrantes;
import com.yopiayllufront.repositories.IntegranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class IntegrantesService {

    @Autowired
    IntegranteRepository integranteRepository;

    public ArrayList<Integrantes> getAllIntegrantesByCodigo(int codigo){
        return integranteRepository.findIntegrantesByFamilias_Codigofamiliar(codigo);
    }

}
