package com.yopiayllufront.services;

import com.yopiayllufront.models.Errores;
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
import java.util.stream.Collectors;

@Service
public class IntegrantesService {
    private HashMap<String, Object> json = new HashMap<>();

    @Autowired
    IntegrantesRepository integrantesRepository;

    @Autowired
    FamiliasRepository familiasRepository;

    private Errores errores = new Errores();


    public Map<String, Object> integrantes_familia(int cod_familiar, Integrantes integrantes){

        boolean aux = familiasRepository.existsByCodigofamiliar(cod_familiar);
        if (aux == false){
            json.put("error",true);
            json.put("detalles","Error al Ingresar Integrantes");
        }else {
            int var = integrantesRepository.countIntegrantesByFamilias_Codigofamiliar(cod_familiar);
            integrantes.setFamilias(familiasRepository.findByCodigofamiliar(cod_familiar));
            if (var ==0){
               integrantes.setLider(true);
            }
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

            Familias familias = familiasRepository.findByCodigofamiliar(codigo_familiar);
            json.put("codigofamiliar",familias.getCodigofamiliar());
            json.put("nombrefamilia",familias.getNombrefamilia());
            json.put("integrantes",obtener_familiares(codigo_familiar));
        }

        return json;
    }

    public Object obtener_familiares(int codigo_familiar){

        boolean aux = familiasRepository.existsByCodigofamiliar(codigo_familiar);
        if (aux==false){
            Errores errores = new Errores();
            errores.setDetalle("Error de Peticion");
            errores.setError(true);
            return errores;
        }else {
            return integrantesRepository.findIntegrantesByFamilias_Codigofamiliar(codigo_familiar).stream().map(item -> {
                item.setFamilias(null);
                return item;
            });
        }
    }

    public Object eliminar_integrante(int idintegrante){

        Integrantes aux = integrantesRepository.searchById(idintegrante);
        if (aux==null){
            errores.setDetalle("Error de Peticion");
            errores.setError(true);
        }else {
            errores.setDetalle("Peticion Aceptada");
            errores.setError(false);
        }
        return errores;


    }

}
