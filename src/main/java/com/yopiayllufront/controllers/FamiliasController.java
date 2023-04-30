package com.yopiayllufront.controllers;

import com.yopiayllufront.models.Familias;
import com.yopiayllufront.models.Integrantes;
import com.yopiayllufront.repositories.FamiliaRepository;
import com.yopiayllufront.repositories.IntegranteRepository;
import com.yopiayllufront.services.IntegrantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
public class FamiliasController {

    @Autowired
    IntegrantesService integrantesService;

    @Autowired
    FamiliaRepository familiaRepository;

//    @GetMapping("/familiares")
//    public ArrayList<Integrantes> getfamiliares(@Param("codigo") int codigo){
//        return integrantesService.getAllIntegrantesByCodigo(codigo);
//    }

    @PostMapping("/familiares/registro")
    public Familias registrar_familiar(@RequestBody Familias familias){
        return familiaRepository.save(familias);
    }



}
