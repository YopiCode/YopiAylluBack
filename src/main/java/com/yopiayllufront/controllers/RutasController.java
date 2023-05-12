package com.yopiayllufront.controllers;

import com.yopiayllufront.utils.Errores;
import com.yopiayllufront.models.RutasModel;
import com.yopiayllufront.services.RutasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RutasController {

    @Autowired
    RutasService rutasService;

    @PostMapping("zona/{codigo}")
    public RutasModel reguistroRuta(@PathVariable("codigo") int codigo, @RequestBody RutasModel request){
        return rutasService.reguistroZona(codigo, request);
    }

    @GetMapping("zona/{codigo}")
    public Object obteneRuta(@PathVariable("codigo") int codigofamiliar){
        return rutasService.MostrarZona(codigofamiliar);
    }

    @DeleteMapping("zona/{id}")
    public Errores deleteRuta(@PathVariable("id")int codigo){
        return rutasService.eliminarZona(codigo);
    }
}
