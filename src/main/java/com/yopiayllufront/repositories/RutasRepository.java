package com.yopiayllufront.repositories;

import com.yopiayllufront.models.RutasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RutasRepository extends JpaRepository<RutasModel,Integer> {

    List<RutasModel> findRutasByFamilias_Codigofamiliar(int codigo_familia);

    void deleteById(int id);

}
