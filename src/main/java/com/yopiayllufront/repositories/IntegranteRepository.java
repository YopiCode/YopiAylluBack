package com.yopiayllufront.repositories;

import com.yopiayllufront.models.Integrantes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface IntegranteRepository extends JpaRepository<Integrantes, Integer> {

    ArrayList<Integrantes> findAllByFamilias_Codigofamiliar(int codigo);
    ArrayList<Integrantes> findIntegrantesByFamilias_Codigofamiliar(int codigo);



}
