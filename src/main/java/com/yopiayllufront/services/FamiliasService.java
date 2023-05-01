package com.yopiayllufront.services;

import com.yopiayllufront.repositories.FamiliasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FamiliasService {

    @Autowired
    FamiliasRepository familiaRepository;

    public Map<String, Object> validarLogin(int codigo_familiar, int contrasena){

        Map<String, Object> json = new HashMap<>();
        boolean aux = familiaRepository.existsByCodigofamiliarAndAndContrasena(codigo_familiar,contrasena);
        if (aux == true){
            json.put("error",false);
            json.put("detalles",null);
        }else {
            json.put("error",true);
            json.put("detalles","Credenciales erroneas");
        }
        return json;

    }




}
