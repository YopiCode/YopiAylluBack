package com.yopiayllufront.services;

import com.yopiayllufront.models.CroquisModel;
import com.yopiayllufront.models.response.HomeResponse;
import com.yopiayllufront.models.response.IntegrantesHomeResponse;
import com.yopiayllufront.models.response.LoginResponse;
import com.yopiayllufront.utils.Errores;
import com.yopiayllufront.models.FamiliasModel;
import com.yopiayllufront.models.IntegrantesModel;
import com.yopiayllufront.repositories.FamiliasRepository;
import com.yopiayllufront.repositories.IntegrantesRepository;
import com.yopiayllufront.utils.InvalidDataExeption;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import javax.security.auth.login.LoginException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

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
    public ResponseEntity<LoginResponse> login_familia(FamiliasModel familias, BindingResult result){
        if (result.hasErrors()){
            throw new InvalidDataExeption(result);
        }
        FamiliasModel example = familiaRepository.findByCodigofamiliar(familias.getCodigofamiliar());
        if (example == null){
            throw new LoginException("No existe el usuario");
        }
        if (!(encoder.matches(familias.getContrasena(),example.getContrasena()))){
            throw new LoginException("Las credenciales son incorrectas");
        }
        //Obj de Consulta
        FamiliasModel familiasModel = familiaRepository.findByCodigofamiliar(familias.getCodigofamiliar());

        //Obj de Respuesta
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setCodigofamiliar(familiasModel.getCodigofamiliar());
        loginResponse.setNombrefamilia(familiasModel.getNombrefamilia());
        IntegrantesModel integrantesModel = integrantesRepository.searchByLider(true);
        loginResponse.setLider((integrantesModel == null) ? null  : integrantesModel.getNombres());
        loginResponse.setCantidad(integrantesRepository.countIntegrantesByFamilias_Codigofamiliar(familiasModel.getCodigofamiliar()));

        return ResponseEntity.status(HttpStatus.CREATED).body(loginResponse);
    }


    public ResponseEntity<LoginResponse> registrar_familia(FamiliasModel familias, BindingResult result){
        FamiliasModel example = new FamiliasModel(familias.getCodigofamiliar());
        if (familiaRepository.exists(Example.of(example))){
            throw new DuplicateKeyException("Ya esta registrado el codigo "+familias.getCodigofamiliar());
        }
        if (result.hasErrors()){
            throw new InvalidDataExeption(result);
        }
        FamiliasModel security = familias;
        security.setContrasena(encoder.encode(familias.getContrasena()));
        familiaRepository.save(security);

        FamiliasModel familiasModel = familiaRepository.findByCodigofamiliar(familias.getCodigofamiliar());

        //Obj de Respuesta
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setCodigofamiliar(familiasModel.getCodigofamiliar());
        loginResponse.setNombrefamilia(familiasModel.getNombrefamilia());
        IntegrantesModel integrantesModel = integrantesRepository.searchByLider(true);
        loginResponse.setLider((integrantesModel == null) ? null  : integrantesModel.getNombres());
        loginResponse.setCantidad(integrantesRepository.countIntegrantesByFamilias_Codigofamiliar(familiasModel.getCodigofamiliar()));




        return ResponseEntity.status(HttpStatus.CREATED).body(loginResponse);
    }

    public ResponseEntity<Object> detalles_Hogar(int codigo, BindingResult result){

        boolean aux = familiaRepository.existsByCodigofamiliar(codigo);
        if (aux == false || result.hasErrors()){
            throw new InvalidDataExeption(result);
        }else {
            FamiliasModel familiasModel = familiaRepository.findByCodigofamiliar(codigo);

            //Obj de Respuesta
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setCodigofamiliar(familiasModel.getCodigofamiliar());
            loginResponse.setNombrefamilia(familiasModel.getNombrefamilia());
            IntegrantesModel integrantesModel = integrantesRepository.searchByLider(true);
            loginResponse.setLider((integrantesModel == null) ? null  : integrantesModel.getNombres());
            loginResponse.setCantidad(integrantesRepository.countIntegrantesByFamilias_Codigofamiliar(familiasModel.getCodigofamiliar()));

            return new ResponseEntity<>(loginResponse,HttpStatus.OK);
        }

    }

}
