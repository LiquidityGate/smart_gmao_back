package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.SubcategoriaDTO;
import com.gmao.gmao_backend.model.Subcategoria;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, uses = {CategoriaMapper.class})
public interface SubcategoriaMapper {

    // Conversión de entidad a DTO, incluyendo el mapeo de Categoria a categoriaId y categoriaNombre
    @Mapping(source = "categoria.id", target = "categoriaId")
    @Mapping(source = "categoria.nombre", target = "categoriaNombre")
    SubcategoriaDTO toDTO(Subcategoria subcategoria);

    // Conversión de DTO a entidad, asignando el ID de la categoría a la entidad
    @Mapping(source = "categoriaId", target = "categoria.id")
    Subcategoria toEntity(SubcategoriaDTO subcategoriaDTO);

    // Actualización parcial de la entidad con valores no nulos del DTO
    void updateFromDTO(SubcategoriaDTO dto, @MappingTarget Subcategoria entity);
}