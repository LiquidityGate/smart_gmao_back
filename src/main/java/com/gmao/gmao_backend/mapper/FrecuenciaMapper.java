package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.FrecuenciaDTO;
import com.gmao.gmao_backend.model.Frecuencia;

import java.util.List;

import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface FrecuenciaMapper {

    // Conversión de entidad a DTO
    FrecuenciaDTO toDTO(Frecuencia frecuencia);

    // Conversión de DTO a entidad
    Frecuencia toEntity(FrecuenciaDTO frecuenciaDTO);

    // Actualización parcial de la entidad con valores no nulos del DTO
    void updateFromDTO(FrecuenciaDTO dto, @MappingTarget Frecuencia entity);

    // Conversión de lista de entidades a lista de DTOs
    @IterableMapping(elementTargetType = FrecuenciaDTO.class)
    List<FrecuenciaDTO> toDTOList(List<Frecuencia> frecuencias);
}