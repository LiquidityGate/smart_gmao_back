package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.Usu_feedbackDTO;
import com.gmao.gmao_backend.model.Usu_feedback;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface Usu_feedbackMapper {

    Usu_feedbackDTO toDto(Usu_feedback usu_feedback);

    Usu_feedback toEntity(Usu_feedbackDTO usu_feedbackDTO);

    void updateFromDto(Usu_feedbackDTO dto, @MappingTarget Usu_feedback entity);
}