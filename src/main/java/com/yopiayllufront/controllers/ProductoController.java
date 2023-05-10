package com.yopiayllufront.controllers;

import com.yopiayllufront.utils.EntityModel;
import com.yopiayllufront.utils.Errores;
import com.yopiayllufront.models.Familias;
import com.yopiayllufront.models.Producto;
import com.yopiayllufront.repositories.ProductoRepository;
import com.yopiayllufront.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @Autowired
    ProductoRepository productoRepository;

    @PostMapping("producto/{codigo}")
    public Producto registrarProducto(@PathVariable("codigo") int codigo, @RequestBody Producto producto){
        System.out.println(producto);
        return productoService.registrarProducto(codigo, producto);
    }

    @GetMapping("producto/{codigo}")
    public Object obtenerProducto(@PathVariable("codigo") int codigo){
        return productoService.mostrarProducto(codigo);

    }

    @DeleteMapping("producto")
    public Errores deleteProducto(@RequestBody Producto producto){
        return productoService.eliminarProducto(producto);
    }



}
