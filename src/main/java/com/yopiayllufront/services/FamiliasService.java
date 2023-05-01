package com.yopiayllufront.services;

import com.yopiayllufront.models.Errores;
import com.yopiayllufront.models.Familias;
import com.yopiayllufront.repositories.FamiliasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class FamiliasService {

    private HashMap<String, Object> json = new HashMap<>();
    private Errores errores = new Errores();

    @Autowired
    FamiliasRepository familiaRepository;

    public Errores login_familia(Familias familias){

        boolean aux = familiaRepository.existsByCodigofamiliarAndAndContrasena(familias.getCodigofamiliar(),familias.getContrasena());
        if (aux == true){
            errores.setError(false);
            errores.setDetalle("Credenciales Correctas");
        }else {
            errores.setError(true);
            errores.setDetalle("Credenciales Erroneas");
        }
        return errores;

    }

    public HashMap<String, Object> registrar_familia(Familias familias){

        if (familias == null){
            errores.setError(true);
            errores.setDetalle("Error de Registro");
        }else {
            errores.setError(false);
            errores.setDetalle("Registro Exitoso");
            familiaRepository.save(familias);
        }
        return json;

    }

}
