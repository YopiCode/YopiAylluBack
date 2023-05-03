package com.yopiayllufront.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yopiayllufront.models.EntityModel;
import com.yopiayllufront.models.Familias;
import com.yopiayllufront.models.Integrantes;
import com.yopiayllufront.repositories.FamiliasRepository;
import com.yopiayllufront.repositories.IntegrantesRepository;
import com.yopiayllufront.services.IntegrantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("familia/{codigo}")
    public Object Obtener_integrantes(@PathVariable("codigo") int codigofamiliar){
        return integrantesService.obtener_familiares(codigofamiliar);
    }

    @GetMapping("home/{codigo}")
    public Map<String, Object> integrantes_familia(@PathVariable("codigo") int codigofamiliar){
        return integrantesService.getAllIntegrantesByCodigo(codigofamiliar) ;
    }

    @DeleteMapping("familia")
    private Object delete_familia(@RequestBody Integrantes integrantes){
        return integrantesService.eliminar_integrante(integrantes.getId());
    }

}
