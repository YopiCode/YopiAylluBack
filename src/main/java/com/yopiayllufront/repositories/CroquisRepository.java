package com.yopiayllufront.repositories;

import com.yopiayllufront.models.CroquisModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CroquisRepository extends JpaRepository<CroquisModel, Integer> {

    List<CroquisModel> getCroquisByFamilias_Codigofamiliar(int codigo_familiar);

    void deleteById(int id);




}