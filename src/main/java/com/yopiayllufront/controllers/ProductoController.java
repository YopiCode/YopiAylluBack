package com.yopiayllufront.controllers;

import com.yopiayllufront.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {

    @Autowired
    ProductoService productoService;

//    @PostMapping("mochila/item")
//    public Producto registrarMochila(@RequestBody Producto producto){
//        return productoService.registrarProducto(producto);
//    }
//
//    @GetMapping("mochila/item")
//    public String obtenerProducto(@RequestBody Familias familias){
//        return productoService.mostrarProducto(familias);
//
//    }



}
