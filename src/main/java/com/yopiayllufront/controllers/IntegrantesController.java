package com.yopiayllufront.controllers;

import com.yopiayllufront.models.response.HomeResponse;
import com.yopiayllufront.models.response.IntegrantesResponse;
import com.yopiayllufront.utils.EntityModel;
import com.yopiayllufront.models.Integrantes;
import com.yopiayllufront.repositories.IntegrantesRepository;
import com.yopiayllufront.services.IntegrantesService;
import com.yopiayllufront.utils.InvalidDataExeption;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class IntegrantesController {

    @Autowired
    IntegrantesRepository integrantesRepository;

    @Autowired
    IntegrantesService integrantesService;

    /*@PostMapping("familia")
    public ResponseEntity<IntegrantesResponse> registrar_integrante(@Valid @RequestBody EntityModel<Integrantes> aux, BindingResult result){
        if (result.hasErrors()){
            throw new InvalidDataExeption(result);
        }
        IntegrantesResponse integrante = integrantesService.integrantes_familia(aux.getCodigofamiliar(),aux.getModel());
        return ResponseEntity.status(HttpStatus.CREATED).body(integrante);
    }*/

    @PostMapping("familia/{codigo}")
    public ResponseEntity<IntegrantesResponse> registrar_integrante(@PathVariable("codigo") int codigo, @Valid @RequestBody Integrantes aux, BindingResult result){
        return integrantesService.integrantes_familia(codigo,aux,result);
    }

    @GetMapping("familia/{codigo}")
    public Object Obtener_integrantes(@PathVariable("codigo") int codigofamiliar){
        return integrantesService.obtener_familiares(codigofamiliar);
    }

    @GetMapping("home/{codigo}")
    public HomeResponse integrantes_familia(@PathVariable("codigo") int codigofamiliar){
        return integrantesService.getAllIntegrantesByCodigo(codigofamiliar) ;
    }

    @DeleteMapping("familia/{id}")
    private int delete_familia(@PathVariable("id") int id){
        return integrantesService.eliminar_integrante(id);
    }

}
