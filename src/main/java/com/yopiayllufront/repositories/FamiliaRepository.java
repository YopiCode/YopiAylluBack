package com.yopiayllufront.repositories;

import com.yopiayllufront.models.Familias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamiliaRepository extends JpaRepository<Familias, Integer> {

    

}
