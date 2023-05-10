package com.yopiayllufront.services;

import com.yopiayllufront.models.response.HomeResponse;
import com.yopiayllufront.models.response.IntegrantesHomeResponse;
import com.yopiayllufront.models.response.IntegrantesResponse;
import com.yopiayllufront.utils.Errores;
import com.yopiayllufront.models.Familias;
import com.yopiayllufront.models.Integrantes;
import com.yopiayllufront.repositories.FamiliasRepository;
import com.yopiayllufront.repositories.IntegrantesRepository;
import com.yopiayllufront.utils.InvalidDataExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IntegrantesService {
    private HashMap<String, Object> json = new HashMap<>();

    @Autowired
    IntegrantesRepository integrantesRepository;

    @Autowired
    FamiliasRepository familiasRepository;

    private Errores errores = new Errores();


    public ResponseEntity<IntegrantesResponse> integrantes_familia(int cod_familiar, Integrantes integrantes, BindingResult result) {
        int var = integrantesRepository.countIntegrantesByFamilias_Codigofamiliar(cod_familiar);
        integrantes.setFamilias(familiasRepository.findByCodigofamiliar(cod_familiar));
        integrantes.setLider(var == 0);
        if (integrantes.getDni() < 10000000 || integrantes.getDni() > 100000000) {
            throw new IllegalArgumentException("Ingrese un dni de 8 digitos");
        }
        Integrantes example = new Integrantes(integrantes.getDni());
        if (integrantesRepository.exists(Example.of(example))) {
            throw new DuplicateKeyException("Ya existe el DNI " + example.getDni());
        }
        if (result.hasErrors()){
            throw new InvalidDataExeption(result);
        }
        IntegrantesResponse inteRpt = new IntegrantesResponse(integrantesRepository.save(integrantes));
        return ResponseEntity.status(HttpStatus.CREATED).body(inteRpt);
    }


    public HomeResponse getAllIntegrantesByCodigo(int codigo_familiar) {
        Familias familias = familiasRepository.findByCodigofamiliar(codigo_familiar);
        HomeResponse response = new HomeResponse();
        response.setNombrefamilia(familias.getNombrefamilia());
        response.setCodigofamiliar(familias.getCodigofamiliar());
        List<Integrantes> allIntegrantes = integrantesRepository.findIntegrantesByFamilias_Codigofamiliar(codigo_familiar);
        List<IntegrantesHomeResponse> integrantesResponse = allIntegrantes
                .stream()
                .map(item -> new IntegrantesHomeResponse(item.getRoles(), item.getNombres()))
                .collect(Collectors.toList());
        response.setIntegrantes(integrantesResponse);
        return response;
    }

    public Object obtener_familiares(int codigo_familiar) {

        boolean aux = familiasRepository.existsByCodigofamiliar(codigo_familiar);
        if (aux == false) {
            Errores errores = new Errores();
            errores.setDetalle("Error de Peticion");
            errores.setError(true);
            return errores;
        } else {
            return integrantesRepository.findIntegrantesByFamilias_Codigofamiliar(codigo_familiar).stream().map(item -> {
                item.setFamilias(null);
                return item;
            });
        }
    }

    public int eliminar_integrante(int idintegrante) {
        integrantesRepository.deleteById(idintegrante);
        return idintegrante;
    }

}
