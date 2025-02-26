package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.PerfilDTO;
import com.gmao.gmao_backend.model.Perfil;

import org.springframework.stereotype.Component;

@Component
public class PerfilMapper {

    // Método para convertir de Entidad a DTO
    public PerfilDTO toDto(Perfil perfil) {
        if (perfil == null) {
            return null;
        }

        PerfilDTO dto = new PerfilDTO();
        dto.setId(perfil.getId());
        dto.setPerfil(perfil.getPerfil());
        return dto;
    }

    // Método para convertir de DTO a Entidad
    public Perfil toEntity(PerfilDTO perfilDTO) {
        if (perfilDTO == null) {
            return null;
        }

        Perfil perfil = new Perfil();
        perfil.setId(perfilDTO.getId());
        perfil.setPerfil(perfilDTO.getPerfil());

        return perfil;
    }
}