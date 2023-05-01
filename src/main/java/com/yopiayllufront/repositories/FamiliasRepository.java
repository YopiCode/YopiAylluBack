package com.yopiayllufront.repositories;

import com.yopiayllufront.models.Familias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamiliasRepository extends JpaRepository<Familias, Integer> {

    boolean existsByCodigofamiliarAndAndContrasena(int codigofamiliar, int contrasena);

    Familias findByCodigofamiliar(int Codigofamiliar);


    

}
