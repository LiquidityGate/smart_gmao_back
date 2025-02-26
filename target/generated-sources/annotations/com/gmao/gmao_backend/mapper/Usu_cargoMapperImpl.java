package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.Usu_cargoDTO;
import com.gmao.gmao_backend.model.Usu_cargo;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-25T14:12:08-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class Usu_cargoMapperImpl implements Usu_cargoMapper {

    @Override
    public Usu_cargoDTO toDto(Usu_cargo usu_cargo) {
        if ( usu_cargo == null ) {
            return null;
        }

        Usu_cargoDTO usu_cargoDTO = new Usu_cargoDTO();

        usu_cargoDTO.setId( usu_cargo.getId() );
        usu_cargoDTO.setNombre( usu_cargo.getNombre() );
        usu_cargoDTO.setEstado( usu_cargo.getEstado() );

        return usu_cargoDTO;
    }

    @Override
    public Usu_cargo toEntity(Usu_cargoDTO usu_cargoDTO) {
        if ( usu_cargoDTO == null ) {
            return null;
        }

        Usu_cargo usu_cargo = new Usu_cargo();

        usu_cargo.setId( usu_cargoDTO.getId() );
        usu_cargo.setNombre( usu_cargoDTO.getNombre() );
        usu_cargo.setEstado( usu_cargoDTO.getEstado() );

        return usu_cargo;
    }

    @Override
    public void updateFromDto(Usu_cargoDTO dto, Usu_cargo entity) {
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
