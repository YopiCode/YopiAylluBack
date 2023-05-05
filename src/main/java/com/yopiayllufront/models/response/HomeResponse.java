package com.yopiayllufront.models.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HomeResponse {

    private Integer codigofamiliar;
    private String nombrefamilia;
    private List<IntegrantesHomeResponse> integrantes;

}
