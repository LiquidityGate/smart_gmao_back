package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.Usu_usuarioDTO;
import com.gmao.gmao_backend.model.Usu_usuario;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface Usu_usuarioMapper {

    Usu_usuarioDTO toDto(Usu_usuario usu_usuario);

    Usu_usuario toEntity(Usu_usuarioDTO usu_usuarioDTO);

    void updateFromDto(Usu_usuarioDTO dto, @MappingTarget Usu_usuario entity);
}