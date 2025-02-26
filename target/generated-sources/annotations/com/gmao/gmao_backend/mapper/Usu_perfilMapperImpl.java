package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.Usu_perfilDTO;
import com.gmao.gmao_backend.model.Usu_perfil;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-25T14:12:10-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class Usu_perfilMapperImpl implements Usu_perfilMapper {

    @Override
    public Usu_perfilDTO toDto(Usu_perfil usu_perfil) {
        if ( usu_perfil == null ) {
            return null;
        }

        Usu_perfilDTO usu_perfilDTO = new Usu_perfilDTO();

        usu_perfilDTO.setId( usu_perfil.getId() );
        usu_perfilDTO.setNombre( usu_perfil.getNombre() );
        usu_perfilDTO.setEstado( usu_perfil.getEstado() );

        return usu_perfilDTO;
    }

    @Override
    public Usu_perfil toEntity(Usu_perfilDTO usu_perfilDTO) {
        if ( usu_perfilDTO == null ) {
            return null;
        }

        Usu_perfil usu_perfil = new Usu_perfil();

        usu_perfil.setId( usu_perfilDTO.getId() );
        usu_perfil.setNombre( usu_perfilDTO.getNombre() );
        usu_perfil.setEstado( usu_perfilDTO.getEstado() );

        return usu_perfil;
    }

    @Override
    public void updateFromDto(Usu_perfilDTO dto, Usu_perfil entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getNombre() != null ) {
            entity.setNombre( dto.getNombre() );
        }
        if ( dto.getEstado() != null ) {
            entity.setEstado( dto.getEstado() );
        }
    }
}
