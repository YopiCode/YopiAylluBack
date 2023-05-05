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

    public Rutas reguistroZona(EntityModel<Rutas> entityModel){
        entityModel.getModel().setFamilias(familiasRepository.findByCodigofamiliar(1234));
        rutasRepository.save(entityModel.getModel());
        entityModel.getModel().setFamilias(null);
        return entityModel.getModel();
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
