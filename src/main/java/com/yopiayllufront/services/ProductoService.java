package com.yopiayllufront.services;

import com.yopiayllufront.utils.EntityModel;
import com.yopiayllufront.utils.Errores;
import com.yopiayllufront.models.Familias;
import com.yopiayllufront.models.Producto;
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
    public Producto registrarProducto(int codigo, Producto request){
        request.setFamilias(familiasRepository.findByCodigofamiliar(codigo));
        productoRepository.save(request);
        request.setFamilias(null);
        return request;
    }

    public Object mostrarProducto(int codigo){
        return productoRepository.searchProductosByFamilias_Codigofamiliar(codigo).stream().peek(item -> item.setFamilias(null));
    }

    public Errores eliminarProducto(Producto producto) {
        productoRepository.deleteById(producto.getId());
        errores.setDetalle("Producto Eliminado Exitosamente");
        errores.setError(false);
        return errores;
    }
}
