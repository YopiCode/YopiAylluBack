package com.yopiayllufront.services;

import com.yopiayllufront.models.EntityModel;
import com.yopiayllufront.models.Errores;
import com.yopiayllufront.models.Familias;
import com.yopiayllufront.models.Producto;
//import com.yopiayllufront.repositories.MochilaRepository;
import com.yopiayllufront.repositories.FamiliasRepository;
import com.yopiayllufront.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class  ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    @Autowired
    FamiliasRepository familiasRepository;

    private Errores errores = new Errores();
    public Producto registrarProducto(EntityModel<Producto> entityModel){
        Producto producto = entityModel.getModel();
        producto.setFamilias(familiasRepository.findByCodigofamiliar(entityModel.getCodigofamiliar()));
        productoRepository.save(producto);
        producto.setFamilias(null);
        return producto;
    }

    public Object mostrarProducto(Familias familias){
        return productoRepository.searchProductosByFamilias_Codigofamiliar(familias.getCodigofamiliar()).stream().map(item -> {
            item.setFamilias(null);
            return item;
        });
    }

    public Errores eliminarProducto(Producto producto) {
        productoRepository.deleteById(producto.getId());
        errores.setDetalle("Producto Eliminado Exitosamente");
        errores.setError(false);
        return errores;
    }
}
