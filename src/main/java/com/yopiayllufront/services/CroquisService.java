package com.yopiayllufront.services;

import com.yopiayllufront.models.Croquis;
import com.yopiayllufront.utils.Errores;
import com.yopiayllufront.models.Familias;
import com.yopiayllufront.repositories.CroquisRepository;
import com.yopiayllufront.repositories.FamiliasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class CroquisService {

    @Autowired
    FamiliasRepository familiasRepository;

    @Autowired
    CroquisRepository croquisRepository;

    private Errores error = new Errores();

    public Errores reguistrarCroquis(MultipartFile multipartFile, int codigo_familiar){
        Familias familias = familiasRepository.findByCodigofamiliar(codigo_familiar);
        if (familias == null){
            error.setError(true);
            error.setDetalle("Error en la Carga");
        }else {
            Croquis croquis = new Croquis();
            croquis.setFamilias(familias);
            croquis.setPiso(1);
            byte[] mapa = null;
            try {
                mapa = multipartFile.getBytes();
                croquis.setMapa(multipartFile.getBytes());
                croquisRepository.save(croquis);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_PNG);
            headers.setContentLength(mapa.length);
            new ResponseEntity<>(mapa, headers, HttpStatus.OK);
            error.setError(false);
            error.setDetalle("Carga Correcta");
        }
        return error;

    }

    public Object obtenerCroquis(int codigo_familiar){
        List<Croquis> croquisList = croquisRepository.getCroquisByFamilias_Codigofamiliar(codigo_familiar);

        if (croquisList == null){
            error.setError(true);
            error.setDetalle("Error de Carga");
            return error;
        }else {

            return croquisList;
        }
    }


    public Errores deleteCroquis(int codigoPiso){
        error.setError(false);
        error.setDetalle("Croquis Eliminado");
        croquisRepository.deleteById(codigoPiso);
        return error;
    }




}
