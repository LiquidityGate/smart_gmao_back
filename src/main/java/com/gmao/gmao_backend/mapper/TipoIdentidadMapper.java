package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.TipoIdentidadDTO;
import com.gmao.gmao_backend.model.TipoIdentidad;

import org.springframework.stereotype.Component;

@Component
public class TipoIdentidadMapper {

    // Método para convertir de Entidad a DTO
    public TipoIdentidadDTO toDto(TipoIdentidad tipoIdentidad) {
        if (tipoIdentidad == null) {
            return null;
        }

        TipoIdentidadDTO dto = new TipoIdentidadDTO();
        dto.setId(tipoIdentidad.getId());
        dto.setTipoIdentidad(tipoIdentidad.getTipoIdentidad());
        return dto;
    }

    // Método para convertir de DTO a Entidad
    public TipoIdentidad toEntity(TipoIdentidadDTO tipoIdentidadDTO) {
        if (tipoIdentidadDTO == null) {
            return null;
        }

        TipoIdentidad tipoIdentidad = new TipoIdentidad();
        tipoIdentidad.setId(tipoIdentidadDTO.getId());
        tipoIdentidad.setTipoIdentidad(tipoIdentidadDTO.getTipoIdentidad());

        return tipoIdentidad;
    }
}