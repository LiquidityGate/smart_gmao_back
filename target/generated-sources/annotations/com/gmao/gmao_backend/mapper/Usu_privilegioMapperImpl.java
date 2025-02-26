package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.Usu_privilegioDTO;
import com.gmao.gmao_backend.model.Usu_privilegio;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-25T14:12:10-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class Usu_privilegioMapperImpl implements Usu_privilegioMapper {

    @Override
    public Usu_privilegioDTO toDto(Usu_privilegio usu_privilegio) {
        if ( usu_privilegio == null ) {
            return null;
        }

        Usu_privilegioDTO usu_privilegioDTO = new Usu_privilegioDTO();

        usu_privilegioDTO.setId( usu_privilegio.getId() );
        usu_privilegioDTO.setNombre( usu_privilegio.getNombre() );
        usu_privilegioDTO.setEstado( usu_privilegio.getEstado() );

        return usu_privilegioDTO;
    }

    @Override
    public Usu_privilegio toEntity(Usu_privilegioDTO usu_privilegioDTO) {
        if ( usu_privilegioDTO == null ) {
            return null;
        }

        Usu_privilegio usu_privilegio = new Usu_privilegio();

        usu_privilegio.setId( usu_privilegioDTO.getId() );
        usu_privilegio.setNombre( usu_privilegioDTO.getNombre() );
        usu_privilegio.setEstado( usu_privilegioDTO.getEstado() );

        return usu_privilegio;
    }

    @Override
    public void updateFromDto(Usu_privilegioDTO dto, Usu_privilegio entity) {
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
