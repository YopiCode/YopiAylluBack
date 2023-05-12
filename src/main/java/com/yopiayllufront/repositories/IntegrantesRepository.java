package com.yopiayllufront.repositories;

import com.yopiayllufront.models.IntegrantesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IntegrantesRepository extends JpaRepository<IntegrantesModel, Integer> {


    List<IntegrantesModel> findIntegrantesByFamilias_Codigofamiliar(int codigo);

    void deleteById(int id);

    IntegrantesModel findByLiderAndFamilias_Codigofamiliar(boolean lider, int codigo);

    int countByFamilias_Codigofamiliar(int codigo);

    int countIntegrantesByFamilias_Codigofamiliar(int codigo);

    IntegrantesModel searchByLider(boolean lider);



}
