package com.yopiayllufront.repositories;

import com.yopiayllufront.models.Planes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PlanesRespository extends JpaRepository<Planes, Integer> {

    ArrayList<Planes> findAllByFamilias_Codigofamiliar(int codigo);

}
