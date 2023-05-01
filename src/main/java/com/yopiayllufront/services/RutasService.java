package com.yopiayllufront.services;

import com.yopiayllufront.models.EntityModel;
import com.yopiayllufront.models.Errores;
import com.yopiayllufront.models.Familias;
import com.yopiayllufront.models.Rutas;
import com.yopiayllufront.repositories.FamiliasRepository;
import com.yopiayllufront.repositories.RutasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class RutasService {

    @Autowired
    RutasRepository rutasRepository;

    @Autowired
    FamiliasRepository familiasRepository;

    private Errores errores = new Errores();

    public Rutas reguistroZona(EntityModel<Rutas> entityModel){
        entityModel.getModel().setFamilias(familiasRepository.findByCodigofamiliar(1234));
        rutasRepository.save(entityModel.getModel());
        entityModel.getModel().setFamilias(null);
        return entityModel.getModel();
    }

    public Object MostrarZona(Familias familias){
        return rutasRepository.findRutasByFamilias_Codigofamiliar(familias.getCodigofamiliar()).stream().map(item ->{
            item.setFamilias(null);
            return item;
        });
    }

    public Errores eliminarZona(int id){
        rutasRepository.deleteById(id);
        errores.setError(false);
        errores.setDetalle("Se elimino de forma Existosa");
        return errores;
    }









}