package com.yopiayllufront.services;

import com.yopiayllufront.utils.EntityModel;
import com.yopiayllufront.utils.Errores;
import com.yopiayllufront.models.Rutas;
import com.yopiayllufront.repositories.FamiliasRepository;
import com.yopiayllufront.repositories.RutasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RutasService {

    @Autowired
    RutasRepository rutasRepository;

    @Autowired
    FamiliasRepository familiasRepository;

    private Errores errores = new Errores();

    public Rutas reguistroZona(int codigo, Rutas request){
        request.setFamilias(familiasRepository.findByCodigofamiliar(codigo));
        rutasRepository.save(request);
        request.setFamilias(null);
        return request;
    }

    public Object MostrarZona(int codigo){
        return rutasRepository.findRutasByFamilias_Codigofamiliar(codigo).stream().peek(item -> item.setFamilias(null));
    }

    public Errores eliminarZona(int id){
        rutasRepository.deleteById(id);
        errores.setError(false);
        errores.setDetalle("Se elimino de forma Existosa");
        return errores;
    }









}
