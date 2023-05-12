package com.yopiayllufront.repositories;

import com.yopiayllufront.models.ProductoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoModel,Integer> {

    List<ProductoModel> searchProductosByFamilias_Codigofamiliar(int cod_familia);

    void deleteById(int id);


}
