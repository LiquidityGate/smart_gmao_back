package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.ListaTiposIdentidadDTO;
import com.gmao.gmao_backend.model.UsuarioTiposIdentidad;

import org.springframework.stereotype.Component;

@Component
public class UsuarioTipoIdentidadMapper {

    // Método para convertir de Entidad a DTO
    public ListaTiposIdentidadDTO toDto(UsuarioTiposIdentidad tipoIdentidad) {
        if (tipoIdentidad == null) {
            return null;
        }

        ListaTiposIdentidadDTO dto = new ListaTiposIdentidadDTO();
        dto.setId(tipoIdentidad.getId());
        dto.setTipoIdentidad(tipoIdentidad.getNombre());
        return dto;
    }

    // Método para convertir de DTO a Entidad
    public UsuarioTiposIdentidad toEntity(ListaTiposIdentidadDTO tipoIdentidadDTO) {
        if (tipoIdentidadDTO == null) {
            return null;
        }

        UsuarioTiposIdentidad tipoIdentidad = new UsuarioTiposIdentidad();
        tipoIdentidad.setId(tipoIdentidadDTO.getId());
        tipoIdentidad.setNombre(tipoIdentidadDTO.getTipoIdentidad());

        return tipoIdentidad;
    }
}