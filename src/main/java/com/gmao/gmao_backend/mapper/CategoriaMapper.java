package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.CategoriaDTO;
import com.gmao.gmao_backend.model.Categoria;

import java.util.List;

import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CategoriaMapper {

    // Conversión de entidad a DTO
    CategoriaDTO toDTO(Categoria categoria);

    // Conversión de DTO a entidad
    Categoria toEntity(CategoriaDTO categoriaDTO);

    // Actualización parcial de la entidad con valores no nulos del DTO
    void updateFromDTO(CategoriaDTO dto, @MappingTarget Categoria entity);

    // Conversión de lista de entidades a lista de DTOs
    @IterableMapping(elementTargetType = CategoriaDTO.class)
    List<CategoriaDTO> toDTOList(List<Categoria> categorias);
}