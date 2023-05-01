package com.yopiayllufront.services;

import com.yopiayllufront.models.Familias;
import com.yopiayllufront.models.Integrantes;
import com.yopiayllufront.repositories.FamiliasRepository;
import com.yopiayllufront.repositories.IntegrantesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class IntegrantesService {

    @Autowired
    IntegrantesRepository integranteRepository;

    @Autowired
    FamiliasRepository familiasRepository;


    public Integrantes integrantes_familia(int codigofamiliar, Integrantes integrantes){
        Integrantes integrantes1 = integrantes;
        integrantes1.setFamilias(familiasRepository.findByCodigofamiliar(codigofamiliar));
        return integrantes1;
    }


    public ArrayList<Integrantes> getAllIntegrantesByCodigo(int codigo){
        return integranteRepository.findIntegrantesByFamilias_Codigofamiliar(codigo);
    }

}
