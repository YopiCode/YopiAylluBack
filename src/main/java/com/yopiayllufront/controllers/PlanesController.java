package com.yopiayllufront.controllers;

import com.yopiayllufront.models.response.PlanesResponse;
import com.yopiayllufront.services.PlanesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("plan")
public class PlanesController {

    @Autowired
    PlanesService planesService;

    @GetMapping("{codigo}")
    public ResponseEntity<ArrayList<PlanesResponse>> getAllPlanes(@PathVariable("codigo") int codigo){
        return planesService.getPlanes(codigo);
    }

}
