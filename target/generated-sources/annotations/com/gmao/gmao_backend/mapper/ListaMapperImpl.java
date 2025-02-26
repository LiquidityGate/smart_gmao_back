package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.ListaDTO;
import com.gmao.gmao_backend.model.Empresa;
import com.gmao.gmao_backend.model.Usu_cargo;
import com.gmao.gmao_backend.model.Usu_turno;
import com.gmao.gmao_backend.model.UsuarioSubtipo;
import com.gmao.gmao_backend.model.UsuarioTiposIdentidad;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-25T14:12:09-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class ListaMapperImpl implements ListaMapper {

    @Override
    public ListaDTO toDtoSubtipo(UsuarioSubtipo subtipo) {
        if ( subtipo == null ) {
            return null;
        }

        ListaDTO listaDTO = new ListaDTO();

        listaDTO.setValor( subtipo.getNombre() );
        listaDTO.setId( subtipo.getId() );

        return listaDTO;
    }

    @Override
    public ListaDTO toDtoEmpresa(Empresa empresa) {
        if ( empresa == null ) {
            return null;
        }

        ListaDTO listaDTO = new ListaDTO();

        listaDTO.setValor( empresa.getNombre() );
        listaDTO.setId( empresa.getId() );

        return listaDTO;
    }

    @Override
    public ListaDTO toDtoTipoIdentidad(UsuarioTiposIdentidad tipoIdentidad) {
        if ( tipoIdentidad == null ) {
            return null;
        }

        ListaDTO listaDTO = new ListaDTO();

        listaDTO.setValor( tipoIdentidad.getNombre() );
        listaDTO.setId( tipoIdentidad.getId() );

        return listaDTO;
    }

    @Override
    public ListaDTO toDtoCargo(Usu_cargo usu_cargo) {
        if ( usu_cargo == null ) {
            return null;
        }

        ListaDTO listaDTO = new ListaDTO();

        listaDTO.setValor( usu_cargo.getNombre() );
        listaDTO.setId( usu_cargo.getId() );

        return listaDTO;
    }

    @Override
    public ListaDTO toDtoTurno(Usu_turno usu_turno) {
        if ( usu_turno == null ) {
            return null;
        }

        ListaDTO listaDTO = new ListaDTO();

        listaDTO.setValor( usu_turno.getTurno() );
        listaDTO.setId( usu_turno.getId() );

        return listaDTO;
    }
}
