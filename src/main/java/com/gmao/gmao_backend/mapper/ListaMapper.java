package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.ListaDTO;
import com.gmao.gmao_backend.model.Empresa;
import com.gmao.gmao_backend.model.Usu_cargo;
import com.gmao.gmao_backend.model.Usu_turno;
import com.gmao.gmao_backend.model.UsuarioSubtipo;
import com.gmao.gmao_backend.model.UsuarioTiposIdentidad;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ListaMapper {

    // Método para convertir de Entidad a DTO
    @Mapping(source = "nombre", target = "valor")
    ListaDTO toDtoSubtipo(UsuarioSubtipo subtipo);

    // Método para convertir de Entidad a DTO
    @Mapping(source = "nombre", target = "valor")
    ListaDTO toDtoEmpresa(Empresa empresa);

    // Método para convertir de Entidad a DTO
    @Mapping(source = "nombre", target = "valor")
    ListaDTO toDtoTipoIdentidad(UsuarioTiposIdentidad tipoIdentidad);

    // Método para convertir de Entidad a DTO
    @Mapping(source = "nombre", target = "valor")
    ListaDTO toDtoCargo(Usu_cargo usu_cargo);

    // Método para convertir de Entidad a DTO
    @Mapping(source = "turno", target = "valor")
    ListaDTO toDtoTurno(Usu_turno usu_turno);
}