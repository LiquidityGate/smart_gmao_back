package com.gmao.gmao_backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class LogModulosDTO {

    private Long id;
    private String url;
    private Long idMenu;
    private Timestamp creadoEn;
    private Long creadoPor;

}