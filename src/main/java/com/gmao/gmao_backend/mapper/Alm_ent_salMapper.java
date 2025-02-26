package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.Alm_ent_salDTO;
import com.gmao.gmao_backend.model.Alm_ent_sal;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface Alm_ent_salMapper {

    Alm_ent_salDTO toDto(Alm_ent_sal alm_ent_sal);

    Alm_ent_sal toEntity(Alm_ent_salDTO alm_ent_salDTO);

    void updateFromDto(Alm_ent_salDTO dto, @MappingTarget Alm_ent_sal entity);
}