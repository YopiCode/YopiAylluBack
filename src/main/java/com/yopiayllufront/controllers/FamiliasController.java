package com.yopiayllufront.controllers;

import com.yopiayllufront.models.Familias;
import com.yopiayllufront.repositories.FamiliasRepository;
import com.yopiayllufront.services.FamiliasService;
import com.yopiayllufront.services.IntegrantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class FamiliasController {

    HashMap<String, Object> json = new HashMap<>();


    @Autowired
    IntegrantesService integrantesService;

    @Autowired
    FamiliasService familiasService;

    @Autowired
    FamiliasRepository familiaRepository;

    @PostMapping("registrar")
    public HashMap<String, Object> registrar_familiar(@RequestBody Familias familias){
        if (familias == null){
            json.put("error",true);
            json.put("Detalle","Error de Registro");
        }else {
            json.put("error",false);
            json.put("Detalle","Registro Exitoso");
            familiaRepository.save(familias);
        }
        return json;
    }

    @PostMapping("ingresar")
    public Map<String, Object> ingresar(@RequestBody Familias familias){

        if (familias == null){
            json.put("error",true);
            json.put("Detalle","Error de Credenciales");
        }else {
            json.put("error",false);
            json.put("Detalle","Credenciales Correctas");
            familiasService.validarLogin(familias.getCodigofamiliar(),familias.getContrasena());
        }
        return json;
    }




}
