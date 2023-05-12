package com.yopiayllufront.controllers;

import com.yopiayllufront.models.FamiliasModel;
import com.yopiayllufront.models.response.HomeResponse;
import com.yopiayllufront.models.response.LoginResponse;
import com.yopiayllufront.services.FamiliasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class AuthController {

    @Autowired
    FamiliasService familiasService;

    @PostMapping("registrar")
    public ResponseEntity<LoginResponse> registrar_familiar(@RequestBody FamiliasModel familias, BindingResult result){
        return familiasService.registrar_familia(familias,result);
    }

    @PostMapping("ingresar")
    public ResponseEntity<LoginResponse> ingresar(@RequestBody FamiliasModel familias, BindingResult result){
        return familiasService.login_familia(familias, result);
    }
}
