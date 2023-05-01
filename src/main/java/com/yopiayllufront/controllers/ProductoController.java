package com.yopiayllufront.controllers;

import com.yopiayllufront.models.EntityModel;
import com.yopiayllufront.models.Errores;
import com.yopiayllufront.models.Familias;
import com.yopiayllufront.models.Producto;
import com.yopiayllufront.repositories.ProductoRepository;
import com.yopiayllufront.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @Autowired
    ProductoRepository productoRepository;

    @PostMapping("producto")
    public Producto registrarProducto(@RequestBody EntityModel<Producto> entityModel){
        return productoService.registrarProducto(entityModel);
    }

    @GetMapping("producto")
    public Object obtenerProducto(@RequestBody Familias familias){
        return productoService.mostrarProducto(familias);

    }

    @DeleteMapping("producto")
    public Errores deleteProducto(@RequestBody Producto producto){
        return productoService.eliminarProducto(producto);
    }



}
