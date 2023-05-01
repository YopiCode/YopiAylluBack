package com.yopiayllufront.repositories;

import com.yopiayllufront.models.Familias;
import com.yopiayllufront.models.Integrantes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FamiliasRepository extends JpaRepository<Familias, Integer> {

    boolean existsByCodigofamiliarAndAndContrasena(int codigofamiliar, int contrasena);
    boolean existsByCodigofamiliar(int codigofamiliar);
    Familias findByCodigofamiliar(int Codigofamiliar);


    

}
