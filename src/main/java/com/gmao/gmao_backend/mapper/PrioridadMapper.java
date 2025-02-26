package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.PrioridadDTO;
import com.gmao.gmao_backend.model.Prioridad;

import java.util.List;

import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PrioridadMapper {

    // Conversión de entidad a DTO
    PrioridadDTO toDTO(Prioridad prioridad);

    // Conversión de DTO a entidad
    Prioridad toEntity(PrioridadDTO prioridadDTO);

    // Actualización parcial de la entidad con valores no nulos del DTO
    void updateFromDTO(PrioridadDTO dto, @MappingTarget Prioridad entity);

    // Conversión de lista de entidades a lista de DTOs
    @IterableMapping(elementTargetType = PrioridadDTO.class)
    List<PrioridadDTO> toDTOList(List<Prioridad> prioridades);
}