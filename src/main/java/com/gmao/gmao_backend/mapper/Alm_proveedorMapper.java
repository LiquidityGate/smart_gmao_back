package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.Alm_proveedorDTO;
import com.gmao.gmao_backend.model.Alm_proveedor;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface Alm_proveedorMapper {

    Alm_proveedorDTO toDto(Alm_proveedor alm_proveedor);

    Alm_proveedor toEntity(Alm_proveedorDTO alm_proveedorDTO);

    void updateFromDto(Alm_proveedorDTO dto, @MappingTarget Alm_proveedor entity);
}