package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.EspecialidadDTO;
import com.gmao.gmao_backend.model.Especialidad;

import java.util.List;

import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface EspecialidadMapper {

    // Conversión de entidad a DTO
    EspecialidadDTO toDTO(Especialidad especialidad);

    // Conversión de DTO a entidad
    Especialidad toEntity(EspecialidadDTO especialidadDTO);

    // Actualización parcial de la entidad con valores no nulos del DTO
    void updateFromDTO(EspecialidadDTO dto, @MappingTarget Especialidad entity);

    // Conversión de lista de entidades a lista de DTOs
    @IterableMapping(elementTargetType = EspecialidadDTO.class)
    List<EspecialidadDTO> toDTOList(List<Especialidad> especialidades);
}