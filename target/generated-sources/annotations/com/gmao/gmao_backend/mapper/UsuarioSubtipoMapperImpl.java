package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.ListaSubtipoDTO;
import com.gmao.gmao_backend.model.UsuarioSubtipo;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-25T14:12:09-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class UsuarioSubtipoMapperImpl implements UsuarioSubtipoMapper {

    @Override
    public ListaSubtipoDTO toDto(UsuarioSubtipo subtipo) {
        if ( subtipo == null ) {
            return null;
        }

        ListaSubtipoDTO listaSubtipoDTO = new ListaSubtipoDTO();

        listaSubtipoDTO.setSubtipo( subtipo.getNombre() );
        listaSubtipoDTO.setId( subtipo.getId() );

        return listaSubtipoDTO;
    }
}
