package com.yopiayllufront.repositories;

import com.yopiayllufront.models.Integrantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface IntegrantesRepository extends JpaRepository<Integrantes, Integer> {


    ArrayList<Integrantes> findIntegrantesByFamilias_Codigofamiliar(int codigo);




}
