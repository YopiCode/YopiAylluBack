package com.yopiayllufront.controllers;

import com.yopiayllufront.models.Familias;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @PostMapping("registrar")
    public ResponseEntity<Familias> registrar_familiar(@RequestBody Familias familias, BindingResult result){
        return familiasService.registrar_familia(familias,result);
    }

    @PostMapping("ingresar")
    public ResponseEntity<Familias> ingresar(@RequestBody Familias familias, BindingResult result){
        return familiasService.login_familia(familias, result);
    }
}
