package com.yopiayllufront.repositories;

import com.yopiayllufront.models.PlanesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PlanesRespository extends JpaRepository<PlanesModel, Integer> {

    ArrayList<PlanesModel> findAllByFamilias_Codigofamiliar(int codigo);

}
