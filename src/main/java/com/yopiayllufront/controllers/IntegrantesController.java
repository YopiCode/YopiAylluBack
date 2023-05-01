package com.yopiayllufront.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
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

@RestController
public class IntegrantesController {

    @Autowired
    IntegrantesRepository integrantesRepository;

    @Autowired
    IntegrantesService integrantesService;

    @PostMapping("familia")
    public Integrantes registrar_integrante(@RequestBody HashMap<String, Object> integrante){
        ObjectMapper objectMapper = new ObjectMapper();
        Integrantes integranteObj = objectMapper.convertValue(integrante.get("integrante"), Integrantes.class);
        int cod_famili = (int)integrante.get("codigofamiliar");
        return integrantesRepository.save(integrantesService.integrantes_familia(cod_famili,integranteObj));
    }

    @GetMapping("home")
    public List<Integrantes> integrantes_familia(@RequestBody HashMap<String, Object> data){
        return integrantesService.getAllIntegrantesByCodigo((Integer) data.get("codigofamiliar"));
    }




}
