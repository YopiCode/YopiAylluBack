package com.yopiayllufront.controllers;

import com.yopiayllufront.models.Croquis;
import com.yopiayllufront.models.Errores;
import com.yopiayllufront.models.Familias;
import com.yopiayllufront.services.CroquisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;

@RestController
public class CroquisController {

    @Autowired
    CroquisService croquisService;

    @PostMapping("piso")
    public Errores registrarPiso(@RequestParam("file") MultipartFile multipartFile, @RequestParam("codigo_familiar") int codigo) {
        return croquisService.reguistrarCroquis(multipartFile,codigo);
    }


    @GetMapping("piso")
    public Object detalle_piso(@RequestBody Familias familias){

        return croquisService.obtenerCroquis(familias.getCodigofamiliar());

    }
    @DeleteMapping("piso")
    public Errores delete_piso(@RequestBody Croquis croquis){
        return croquisService.deleteCroquis(croquis.getId());
    }






}
