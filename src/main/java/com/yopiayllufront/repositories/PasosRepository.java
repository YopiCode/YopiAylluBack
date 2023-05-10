package com.yopiayllufront.repositories;

import com.yopiayllufront.models.Pasos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface PasosRepository extends JpaRepository<Pasos, Integer> {

    ArrayList<Pasos> findAllByPlanes_Id(int id);

}
