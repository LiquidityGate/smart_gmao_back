package com.gmao.gmao_backend.mapper.AdministracionUsuarios.Configuracion;

import com.gmao.gmao_backend.dto.AdministracionUsuarios.Configuracion.MantenimientoCargos.MantenimientoCargosTablaDTO;
import com.gmao.gmao_backend.model.UsuarioCargo;

import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MantenimientoCargosMapper {

        // -------------------------------------------------------------------
        // Tabla
        MantenimientoCargosTablaDTO toDtoTabla(UsuarioCargo usuario);

        UsuarioCargo toEntityTabla(MantenimientoCargosTablaDTO dto);

        // Actualización parcial de la entidad con valores no nulos del DTO
        void updateFromDto(MantenimientoCargosTablaDTO dto, @MappingTarget UsuarioCargo entity);

}