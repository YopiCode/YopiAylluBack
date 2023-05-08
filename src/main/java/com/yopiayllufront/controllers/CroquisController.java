package com.yopiayllufront.controllers;

import com.yopiayllufront.models.Croquis;
import com.yopiayllufront.services.CroquisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("piso")
public class CroquisController {
    @Autowired
    CroquisService croquisService;

    @PostMapping("/{codigo}")
    public ResponseEntity<Croquis> registrarPiso(@PathVariable("codigo") int codigo, @RequestBody Croquis request) {
        return croquisService.reguistrarCroquis(codigo, request);
    }


    @GetMapping("/{codigo}")
    public ResponseEntity<byte[]> detalle_piso(@PathVariable("codigo") int codigo){
        return croquisService.obtenerCroquis(codigo);

    }
    @DeleteMapping("/{id}")
    public int delete_piso(@PathVariable("id") int id){
        return croquisService.deleteCroquis(id);
    }

}
