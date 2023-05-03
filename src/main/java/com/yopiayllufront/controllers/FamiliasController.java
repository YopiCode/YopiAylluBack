package com.yopiayllufront.controllers;

import com.yopiayllufront.models.Errores;
import com.yopiayllufront.models.Familias;
import com.yopiayllufront.repositories.FamiliasRepository;
import com.yopiayllufront.services.FamiliasService;
import com.yopiayllufront.services.IntegrantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("hogar/{codigo}")
    public Object hogar(@PathVariable("codigo") int codigofamiliar){
        return familiasService.detalles_Hogar(codigofamiliar);
    }




}
