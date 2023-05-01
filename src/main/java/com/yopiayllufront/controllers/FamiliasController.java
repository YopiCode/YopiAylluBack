package com.yopiayllufront.controllers;

import com.yopiayllufront.models.Familias;
import com.yopiayllufront.repositories.FamiliasRepository;
import com.yopiayllufront.services.FamiliasService;
import com.yopiayllufront.services.IntegrantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class FamiliasController {

    @Autowired
    IntegrantesService integrantesService;

    @Autowired
    FamiliasService familiasService;

    @Autowired
    FamiliasRepository familiaRepository;

    @PostMapping("registrar")
    public Familias registrar_familiar(@RequestBody Familias familias){
        return familiaRepository.save(familias);
    }

    @PostMapping("ingresar")
    public Map<String, Object> ingresar(@RequestBody Map<String, Object> familias){
        return familiasService.validarLogin((int)familias.get("codigofamiliar"),(int)familias.get("contrasena"));
    }




}
