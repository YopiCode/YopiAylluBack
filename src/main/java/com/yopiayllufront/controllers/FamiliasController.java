package com.yopiayllufront.controllers;

import com.yopiayllufront.models.Integrantes;
import com.yopiayllufront.repositories.IntegranteRepository;
import com.yopiayllufront.services.IntegrantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class FamiliasController {

    @Autowired
    IntegrantesService integrantesService;

    @GetMapping("/familiares")
    public ArrayList<Integrantes> getfamiliares(@Param("codigo") int codigo){
        return integrantesService.getAllIntegrantesByCodigo(codigo);
    }

}
