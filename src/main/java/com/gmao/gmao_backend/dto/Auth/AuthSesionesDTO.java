package com.gmao.gmao_backend.dto.Auth;

import lombok.Getter;
import lombok.Setter;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthSesionesDTO {

    private String ruta;
    private String ipAddress;
    private String userAgent;
    private Boolean acceso;
    private String tokenJWT;
}