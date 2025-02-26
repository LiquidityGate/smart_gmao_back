package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.TipoReprogramacionDTO;
import com.gmao.gmao_backend.model.TipoReprogramacion;

import java.util.List;

import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TipoReprogramacionMapper {

    // Conversión de entidad a DTO
    TipoReprogramacionDTO toDTO(TipoReprogramacion tipoReprogramacion);

    // Conversión de DTO a entidad
    TipoReprogramacion toEntity(TipoReprogramacionDTO tipoReprogramacionDTO);

    // Actualización parcial de la entidad con valores no nulos del DTO
    void updateFromDTO(TipoReprogramacionDTO dto, @MappingTarget TipoReprogramacion entity);

    // Conversión de lista de entidades a lista de DTOs
    @IterableMapping(elementTargetType = TipoReprogramacionDTO.class)
    List<TipoReprogramacionDTO> toDTOList(List<TipoReprogramacion> tipoReprogramaciones);
}