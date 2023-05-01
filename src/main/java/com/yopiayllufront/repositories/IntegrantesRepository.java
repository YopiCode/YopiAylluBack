package com.yopiayllufront.repositories;

import com.yopiayllufront.models.Integrantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface IntegrantesRepository extends JpaRepository<Integrantes, Integer> {


    List<Integrantes> findIntegrantesByFamilias_Codigofamiliar(int codigo);

    void deleteById(int id);
    Integrantes searchById(int id);

    Integrantes findByLiderAndFamilias_Codigofamiliar(boolean lider,int codigo);

    int countByFamilias_Codigofamiliar(int codigo);




}
