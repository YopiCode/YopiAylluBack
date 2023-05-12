package com.yopiayllufront.repositories;

import com.yopiayllufront.models.PasosModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface PasosRepository extends JpaRepository<PasosModel, Integer> {

    ArrayList<PasosModel> findAllByPlanes_Id(int id);

}
