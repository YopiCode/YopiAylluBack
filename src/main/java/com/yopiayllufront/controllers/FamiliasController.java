package com.yopiayllufront.controllers;

import com.yopiayllufront.models.CroquisModel;
import com.yopiayllufront.services.FamiliasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
public class FamiliasController {
    @Autowired
    FamiliasService familiasService;

    @GetMapping("hogar/{codigo}")
    public ResponseEntity<Object> hogar(@PathVariable("codigo") int codigofamiliar, @RequestBody BindingResult result){
        return familiasService.detalles_Hogar(codigofamiliar, result);
    }




}
