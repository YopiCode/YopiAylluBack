package com.yopiayllufront.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yopiayllufront.models.EntityModel;
import com.yopiayllufront.models.Familias;
import com.yopiayllufront.models.Integrantes;
import com.yopiayllufront.repositories.FamiliasRepository;
import com.yopiayllufront.repositories.IntegrantesRepository;
import com.yopiayllufront.services.IntegrantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class IntegrantesController {

    @Autowired
    IntegrantesRepository integrantesRepository;

    @Autowired
    IntegrantesService integrantesService;

    @PostMapping("familia")
    public Map<String, Object> registrar_integrante(@RequestBody EntityModel<Integrantes> aux){
        return integrantesService.integrantes_familia(aux.getCodigofamiliar(),aux.getModel());
    }

    @GetMapping("home")
    public Map<String, Object> integrantes_familia(@RequestBody Familias familias){
        return integrantesService.getAllIntegrantesByCodigo(familias.getCodigofamiliar()) ;
    }




}
