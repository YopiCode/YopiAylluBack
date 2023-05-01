package com.yopiayllufront.repositories;

import com.yopiayllufront.models.Croquis;
import com.yopiayllufront.models.Familias;
import com.yopiayllufront.models.Integrantes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CroquisRepository extends JpaRepository<Croquis, Integer> {

    List<Croquis> getCroquisByFamilias_Codigofamiliar(int codigo_familiar);

    void deleteById(int id);




}