package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.UsuarioSelectDTO;
import com.gmao.gmao_backend.dto.AdministracionUsuariosDTO;
import com.gmao.gmao_backend.model.AdministracionUsuarios;
import com.gmao.gmao_backend.model.AdministracionUsuariosIDName;

import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AdministracionUsuariosMapper {

    // Método para convertir AdministracionUsuarios a UsuarioSelectDTO
    @Mapping(target = "nombreCompleto", expression = "java(administracionUsuarios.getNombres() + ' ' + administracionUsuarios.getApellidos())")
    UsuarioSelectDTO toUsuarioSelectDto(AdministracionUsuarios administracionUsuarios);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "nombres", target = "nombres")
    @Mapping(source = "apellidos", target = "apellidos")
    AdministracionUsuariosIDName toPartial(AdministracionUsuarios administracionUsuarios);

    // Otros métodos existentes para AdministracionUsuariosDTO
    @Mapping(source = "tipoIdentidad.id", target = "idTipoIdentidad")
    @Mapping(target = "valorTipoIdentidad", expression = "java(administracionUsuarios.getTipoIdentidad() != null ? administracionUsuarios.getTipoIdentidad().getNombre() : null)")
    @Mapping(source = "subtipoUsuario.id", target = "idSubtipoUsuario")
    @Mapping(target = "valorSubtipoUsuario", expression = "java(administracionUsuarios.getSubtipoUsuario() != null ? administracionUsuarios.getSubtipoUsuario().getNombre() : null)")
    @Mapping(source = "perfil.id", target = "idPerfil")
    @Mapping(target = "valorPerfil", expression = "java(administracionUsuarios.getPerfil() != null ? administracionUsuarios.getPerfil().getNombre() : null)")
    AdministracionUsuariosDTO toDto(AdministracionUsuarios administracionUsuarios);

    AdministracionUsuarios toEntity(AdministracionUsuariosDTO administracionUsuariosDTO);
}