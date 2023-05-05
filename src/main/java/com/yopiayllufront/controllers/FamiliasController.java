package com.yopiayllufront.controllers;

import com.yopiayllufront.models.Familias;
import com.yopiayllufront.services.FamiliasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FamiliasController {
    @Autowired
    FamiliasService familiasService;

    @PostMapping("registrar")
    public Boolean registrar_familiar(@RequestBody Familias familias){
        return familiasService.registrar_familia(familias);
    }

    @PostMapping("ingresar")
    public Boolean ingresar(@RequestBody Familias familias){
        return familiasService.login_familia(familias);
    }

    @GetMapping("hogar/{codigo}")
    public Object hogar(@PathVariable("codigo") int codigofamiliar){
        return familiasService.detalles_Hogar(codigofamiliar);
    }




}
