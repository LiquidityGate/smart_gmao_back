package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.ListaSubtipoDTO;
import com.gmao.gmao_backend.model.UsuarioSubtipo;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UsuarioSubtipoMapper {

    // Método para convertir de Entidad a DTO
    @Mapping(source = "nombre", target = "subtipo")
    ListaSubtipoDTO toDto(UsuarioSubtipo subtipo);
}