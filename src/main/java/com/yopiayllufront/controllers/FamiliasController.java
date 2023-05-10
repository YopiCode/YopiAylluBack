package com.yopiayllufront.controllers;

import com.yopiayllufront.models.Familias;
import com.yopiayllufront.services.FamiliasService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
public class FamiliasController {
    @Autowired
    FamiliasService familiasService;



    @GetMapping("hogar/{codigo}")
    public Object hogar(@PathVariable("codigo") int codigofamiliar){
        return familiasService.detalles_Hogar(codigofamiliar);
    }




}
