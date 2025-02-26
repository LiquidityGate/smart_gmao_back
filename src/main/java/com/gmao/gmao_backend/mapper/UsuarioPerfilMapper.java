package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.MantenimientoPerfiles.MantenimientoPerfilesDTO;
import com.gmao.gmao_backend.model.UsuarioPerfil;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UsuarioPerfilMapper {

    // Conversión de entidad a DTO
    @Mapping(source = "creadoPor", target = "creadoPorId")
    @Mapping(source = "actualizadoPor", target = "actualizadoPorId")
    @Mapping(target = "creadoPorNombre", constant = "")
    @Mapping(target = "actualizadoPorNombre", constant = "")
    MantenimientoPerfilesDTO toDto(UsuarioPerfil usrPerfil);

    default MantenimientoPerfilesDTO toDto(UsuarioPerfil usuarioPerfil, String creadoPorNombreCompleto,
            String actualizadoPorNombreCompleto) {
        MantenimientoPerfilesDTO dto = toDto(usuarioPerfil);
        dto.setCreadoPorNombre(creadoPorNombreCompleto);
        dto.setActualizadoPorNombre(actualizadoPorNombreCompleto);
        return dto;
    }

    // Conversión de DTO a entidad
    @Mapping(source = "creadoPorId", target = "creadoPor")
    @Mapping(source = "actualizadoPorId", target = "actualizadoPor")
    UsuarioPerfil toEntity(MantenimientoPerfilesDTO usrPerfilDTO);

    // Actualización parcial de la entidad con valores no nulos del DTO
    @Mapping(source = "creadoPorId", target = "creadoPor")
    @Mapping(source = "actualizadoPorId", target = "actualizadoPor")
    void updateFromDto(MantenimientoPerfilesDTO dto, @MappingTarget UsuarioPerfil entity);

}