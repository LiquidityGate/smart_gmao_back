package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.CategoriasDTO;
import com.gmao.gmao_backend.model.Categorias;

import java.util.List;

import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CategoriasMapper {

    // Conversión de entidad a DTO
    CategoriasDTO toDTO(Categorias categorias);

    // Conversión de DTO a entidad
    Categorias toEntity(CategoriasDTO categoriasDTO);

    // Actualización parcial de la entidad con valores no nulos del DTO
    void updateFromDTO(CategoriasDTO dto, @MappingTarget Categorias entity);

    // Conversión de lista de entidades a lista de DTOs
    @IterableMapping(elementTargetType = CategoriasDTO.class)
    List<CategoriasDTO> toDTOList(List<Categorias> categorias);
}

