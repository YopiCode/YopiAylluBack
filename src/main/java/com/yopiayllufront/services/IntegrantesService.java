package com.yopiayllufront.services;

import com.yopiayllufront.models.Familias;
import com.yopiayllufront.models.Integrantes;
import com.yopiayllufront.repositories.FamiliasRepository;
import com.yopiayllufront.repositories.IntegrantesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IntegrantesService {
    private HashMap<String, Object> json = new HashMap<>();

    @Autowired
    IntegrantesRepository integrantesRepository;

    @Autowired
    FamiliasRepository familiasRepository;


    public Map<String, Object> integrantes_familia(int cod_familiar, Integrantes integrantes){

        boolean aux = familiasRepository.existsByCodigofamiliar(cod_familiar);
        if (aux == false){
            json.put("error",true);
            json.put("detalles","Error al Ingresar Integrantes");
        }else {
            integrantes.setFamilias(familiasRepository.findByCodigofamiliar(cod_familiar));
            json.put("integrantes",integrantes);
            integrantesRepository.save(integrantes);

        }
        return json;
    }


    public HashMap<String, Object> getAllIntegrantesByCodigo(int codigo_familiar){

        boolean aux = familiasRepository.existsByCodigofamiliar(codigo_familiar);
        if (aux==false){
            json.put("error",true);
            json.put("detalles","Credenciales Erroneas");
        }else {
            json.put("codigofamiliar",familiasRepository.findByCodigofamiliar(codigo_familiar).getCodigofamiliar());
            json.put("nombrefamilia",familiasRepository.findByCodigofamiliar(codigo_familiar).getNombrefamilia());
            json.put("integrantes",integrantesRepository.findIntegrantesByFamilias_Codigofamiliar(codigo_familiar));
        }

        return json;
    }

}
