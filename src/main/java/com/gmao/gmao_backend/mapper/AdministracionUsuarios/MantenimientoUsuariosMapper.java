package com.gmao.gmao_backend.mapper.AdministracionUsuarios;

import com.gmao.gmao_backend.dto.AdministracionUsuarios.MantenimientoUsuarios.MantenimientoUsuariosFichaDietaDTO;
import com.gmao.gmao_backend.dto.AdministracionUsuarios.MantenimientoUsuarios.MantenimientoUsuariosFichaLaboralDTO;
import com.gmao.gmao_backend.dto.AdministracionUsuarios.MantenimientoUsuarios.MantenimientoUsuariosFichaUsuarioDTO;
import com.gmao.gmao_backend.dto.AdministracionUsuarios.MantenimientoUsuarios.MantenimientoUsuariosTablaDTO;
import com.gmao.gmao_backend.model.Usuario;
import com.gmao.gmao_backend.model.UsuarioDieta;

import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MantenimientoUsuariosMapper {

        // -------------------------------------------------------------------
        // Tabla
        @Mapping(source = "perfil.nombre", target = "valorPerfil")
        MantenimientoUsuariosTablaDTO toDtoTabla(Usuario usuario);

        Usuario toEntityTabla(MantenimientoUsuariosTablaDTO dto);

        // Actualización parcial de la entidad con valores no nulos del DTO
        void updateFromDto(MantenimientoUsuariosTablaDTO dto, @MappingTarget Usuario entity);

        // -------------------------------------------------------------------
        // Ficha Usuario
        MantenimientoUsuariosFichaUsuarioDTO toDtoFichaUsuario(Usuario usuario);

        void updateFromMantenimientoUsuariosFichaUsuarioDTO(MantenimientoUsuariosFichaUsuarioDTO dto,
                        @MappingTarget Usuario entity);

        // -------------------------------------------------------------------
        // Ficha Laboral
        MantenimientoUsuariosFichaLaboralDTO toDtoFichaLaboral(Usuario usuario);

        void updateFromMantenimientoUsuariosFichaLaboralDTO(MantenimientoUsuariosFichaLaboralDTO dto,
                        @MappingTarget Usuario entity);

        // -------------------------------------------------------------------
        // Ficha Dieta
        UsuarioDieta toEntityFichaDietaDTO(MantenimientoUsuariosFichaDietaDTO dto);

}