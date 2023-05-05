package com.yopiayllufront.controllers;

import com.yopiayllufront.utils.EntityModel;
import com.yopiayllufront.utils.Errores;
import com.yopiayllufront.models.Rutas;
import com.yopiayllufront.services.RutasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RutasController {

    @Autowired
    RutasService rutasService;

    @PostMapping("zona")
    public Rutas reguistroRuta(@RequestBody EntityModel<Rutas> entityModel){
        return rutasService.reguistroZona(entityModel);
    }

    @GetMapping("zona/{codigo}")
    public Object obteneRuta(@PathVariable("codigo") int codigofamiliar){
        return rutasService.MostrarZona(codigofamiliar);
    }

    @DeleteMapping("zona")
    public Errores deleteRuta(@RequestBody Rutas rutas){
        return rutasService.eliminarZona(rutas.getId());
    }
}
