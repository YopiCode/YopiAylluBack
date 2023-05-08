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

    @PostMapping("registrar")
    public ResponseEntity<Familias> registrar_familiar(@RequestBody Familias familias, BindingResult result){
        return familiasService.registrar_familia(familias,result);
    }

    @PostMapping("ingresar")
    public ResponseEntity<Familias> ingresar(@RequestBody Familias familias, BindingResult result){
        return familiasService.login_familia(familias, result);
    }

    @GetMapping("hogar/{codigo}")
    public Object hogar(@PathVariable("codigo") int codigofamiliar){
        return familiasService.detalles_Hogar(codigofamiliar);
    }




}
