package com.yopiayllufront.services;

import com.yopiayllufront.utils.Errores;
import com.yopiayllufront.models.Familias;
import com.yopiayllufront.models.Integrantes;
import com.yopiayllufront.repositories.FamiliasRepository;
import com.yopiayllufront.repositories.IntegrantesRepository;
import com.yopiayllufront.utils.InvalidDataExeption;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

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

    @Autowired
    BCryptPasswordEncoder encoder;
    @SneakyThrows
    public ResponseEntity<Familias> login_familia(Familias familias, BindingResult result){
        Familias example = familiaRepository.findByCodigofamiliar(familias.getCodigofamiliar());
        if (!(example ==null) && !(encoder.matches(familias.getContrasena(),example.getContrasena()))){
            throw new LoginException("Las credenciales son incorrectas");
        }

        if (result.hasErrors()){
            throw new InvalidDataExeption(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(familias);
    }


    public ResponseEntity<Familias> registrar_familia(Familias familias, BindingResult result){


        Familias example = new Familias(familias.getCodigofamiliar());
        if (familiaRepository.exists(Example.of(example))){
            throw new DuplicateKeyException("Ya esta registrado el codigo "+familias.getCodigofamiliar());
        }
        if (result.hasErrors()){
            throw new InvalidDataExeption(result);
        }
        Familias security = familias;
        security.setContrasena(encoder.encode(familias.getContrasena()));
        familiaRepository.save(security);
        return ResponseEntity.status(HttpStatus.CREATED).body(familias);
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
