package com.yopiayllufront.repositories;

import com.yopiayllufront.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Integer> {

    @Override
    List<Producto> findAll();
}
