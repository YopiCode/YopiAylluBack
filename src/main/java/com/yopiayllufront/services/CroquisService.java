package com.yopiayllufront.services;

import com.yopiayllufront.models.CroquisModel;
import com.yopiayllufront.models.FamiliasModel;
import com.yopiayllufront.repositories.CroquisRepository;
import com.yopiayllufront.repositories.FamiliasRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Service
public class CroquisService {

    @Autowired
    FamiliasRepository familiasRepository;

    @Autowired
    CroquisRepository croquisRepository;

    public ResponseEntity<CroquisModel> reguistrarCroquis(int codigo, CroquisModel request) {
        FamiliasModel familias = familiasRepository.findByCodigofamiliar(codigo);
        request.setFamilias(familias);
        return new ResponseEntity<>(croquisRepository.save(request), HttpStatus.OK);
    }

    @SneakyThrows
    public ResponseEntity<byte[]> obtenerCroquis(int codigo_familiar) {
        List<CroquisModel> croquisList = croquisRepository.getCroquisByFamilias_Codigofamiliar(codigo_familiar);

        if (croquisList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ZipOutputStream zos = new ZipOutputStream(baos);

        for (CroquisModel croquis : croquisList) {
            ZipEntry entry = new ZipEntry("croquis-" + croquis.getId() + ".png");
            zos.putNextEntry(entry);
            zos.write(croquis.getMapa());
            zos.closeEntry();
        }

        zos.close();

        byte[] zipBytes = baos.toByteArray();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "croquis.zip");

        return new ResponseEntity<>(zipBytes, headers, HttpStatus.OK);
    }


    public int deleteCroquis(int id){
        croquisRepository.deleteById(id);
        return id;
    }




}
