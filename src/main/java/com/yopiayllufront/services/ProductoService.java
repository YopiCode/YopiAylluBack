package com.yopiayllufront.services;

import com.yopiayllufront.utils.Errores;
import com.yopiayllufront.models.ProductoModel;
//import com.yopiayllufront.repositories.MochilaRepository;
import com.yopiayllufront.repositories.FamiliasRepository;
import com.yopiayllufront.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class  ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    @Autowired
    FamiliasRepository familiasRepository;

    private Errores errores = new Errores();
    public ProductoModel registrarProducto(int codigo, ProductoModel request){
        request.setFamilias(familiasRepository.findByCodigofamiliar(codigo));
        productoRepository.save(request);
        request.setFamilias(null);
        return request;
    }

    public Object mostrarProducto(int codigo){
        return productoRepository.searchProductosByFamilias_Codigofamiliar(codigo).stream().peek(item -> item.setFamilias(null));
    }

    public Errores eliminarProducto( int id) {
        productoRepository.deleteById(id);
        errores.setDetalle("Producto Eliminado Exitosamente");
        errores.setError(false);
        return errores;
    }
}
