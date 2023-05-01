package com.yopiayllufront.repositories;

import com.yopiayllufront.models.Rutas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface RutasRepository extends JpaRepository<Rutas,Integer> {

    List<Rutas> findRutasByFamilias_Codigofamiliar(int codigo_familia);

    void deleteById(int id);

}
