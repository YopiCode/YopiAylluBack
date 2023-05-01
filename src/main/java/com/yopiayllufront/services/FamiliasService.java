package com.yopiayllufront.services;

import com.yopiayllufront.models.Errores;
import com.yopiayllufront.models.Familias;
import com.yopiayllufront.models.Integrantes;
import com.yopiayllufront.repositories.FamiliasRepository;
import com.yopiayllufront.repositories.IntegrantesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class FamiliasService {

    private HashMap<String, Object> json = new HashMap<>();
    private Errores errores = new Errores();

    @Autowired
    FamiliasRepository familiaRepository;

    @Autowired
    IntegrantesRepository integrantesRepository;

    public Errores login_familia(Familias familias){

        boolean aux = familiaRepository.existsByCodigofamiliarAndAndContrasena(familias.getCodigofamiliar(),familias.getContrasena());
        if (aux == true){
            errores.setError(false);
            errores.setDetalle("Credenciales Correctas");
        }else {
            errores.setError(true);
            errores.setDetalle("Credenciales Erroneas");
        }
        return errores;

    }

    public Errores registrar_familia(Familias familias){

        if (familias == null){
            errores.setError(true);
            errores.setDetalle("Error de Registro");
        }else {
            errores.setError(false);
            errores.setDetalle("Registro Exitoso");
            familiaRepository.save(familias);
        }
        return errores;

    }

    public Object detalles_Hogar(int codigo){
        boolean aux = familiaRepository.existsByCodigofamiliar(codigo);
        if (aux == false){
            errores.setError(true);
            errores.setDetalle("Error detalle Hogar");
            return errores;
        }else {
            Integrantes integrantes =  integrantesRepository.findByLiderAndFamilias_Codigofamiliar(true, codigo);
            json.put("cantidad",integrantesRepository.countByFamilias_Codigofamiliar(codigo));
            json.put("codigofamiliar",integrantes.getFamilias().getCodigofamiliar());
            json.put("lider",integrantes.getNombres());
            json.put("nombrefamilia",integrantes.getFamilias().getNombrefamilia());
            return json;
        }
    }

}
