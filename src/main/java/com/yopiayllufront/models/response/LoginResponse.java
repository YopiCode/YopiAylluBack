package com.yopiayllufront.models.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class LoginResponse {
    private Integer codigofamiliar;
    private String nombrefamilia;
    private String lider;
    private int cantidad;
}
