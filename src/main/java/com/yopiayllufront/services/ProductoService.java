package com.yopiayllufront.services;

import com.yopiayllufront.models.Familias;
import com.yopiayllufront.models.Producto;
//import com.yopiayllufront.repositories.MochilaRepository;
import com.yopiayllufront.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

    @Autowired
    ProductoRepository productoRepository;

//    @Autowired
//    MochilaRepository mochilaRepository;

    public Producto registrarProducto(Producto producto){
        return productoRepository.save(producto);
    }

//    public String mostrarProducto(Familias familias){
//        System.out.println(mochilaRepository.findByFamilias_Codigofamiliar(familias.getCodigofamiliar()));
//        return "";
//    }
}
