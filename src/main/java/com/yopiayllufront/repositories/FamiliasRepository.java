package com.yopiayllufront.repositories;

import com.yopiayllufront.models.FamiliasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamiliasRepository extends JpaRepository<FamiliasModel, Integer> {

    boolean existsByCodigofamiliar(int codigofamiliar);
    FamiliasModel findByCodigofamiliar(int Codigofamiliar);









}
