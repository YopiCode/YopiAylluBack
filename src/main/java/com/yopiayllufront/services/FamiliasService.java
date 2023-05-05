package com.yopiayllufront.services;

import com.yopiayllufront.utils.Errores;
import com.yopiayllufront.models.Familias;
import com.yopiayllufront.models.Integrantes;
import com.yopiayllufront.repositories.FamiliasRepository;
import com.yopiayllufront.repositories.IntegrantesRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;
import java.util.HashMap;

@Service
public class FamiliasService {

    private HashMap<String, Object> json = new HashMap<>();
    private Errores errores = new Errores();

    @Autowired
    FamiliasRepository familiaRepository;

    @Autowired
    IntegrantesRepository integrantesRepository;

    @SneakyThrows
    public Boolean login_familia(Familias familias){
        Familias example = new Familias(familias.getCodigofamiliar(), familias.getContrasena());
        if (!familiaRepository.exists(Example.of(example))){
            throw new LoginException("Las credenciales son incorrectas");
        }
        return true;
    }

    public Boolean registrar_familia(Familias familias){
        Familias example = new Familias(familias.getCodigofamiliar());
        if (familiaRepository.exists(Example.of(example))){
            throw new DuplicateKeyException("Ya esta registrado el codigo "+familias.getCodigofamiliar());
        }
        return true;
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
