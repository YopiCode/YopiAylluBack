package com.yopiayllufront.controllers;

import com.yopiayllufront.models.Errores;
import com.yopiayllufront.models.Familias;
import com.yopiayllufront.repositories.FamiliasRepository;
import com.yopiayllufront.services.FamiliasService;
import com.yopiayllufront.services.IntegrantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
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
    public Errores registrar_familiar(@RequestBody Familias familias){
        return familiasService.registrar_familia(familias);
    }

    @PostMapping("ingresar")
    public Errores ingresar(@RequestBody Familias familias){
        return familiasService.login_familia(familias);
    }

    @GetMapping("hogar")
    public Object hogar(@RequestBody Familias familias){
        return familiasService.detalles_Hogar(familias.getCodigofamiliar());
    }




}
