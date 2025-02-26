package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.Alm_almacenDTO;
import com.gmao.gmao_backend.model.Alm_almacen;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-25T14:12:10-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class Alm_almacenMapperImpl implements Alm_almacenMapper {

    @Override
    public Alm_almacenDTO toDto(Alm_almacen alm_almacen) {
        if ( alm_almacen == null ) {
            return null;
        }

        Alm_almacenDTO alm_almacenDTO = new Alm_almacenDTO();

        alm_almacenDTO.setId( alm_almacen.getId() );
        alm_almacenDTO.setNombre( alm_almacen.getNombre() );
        alm_almacenDTO.setCod_alm_padre( alm_almacen.getCod_alm_padre() );
        alm_almacenDTO.setNom_alm_padre( alm_almacen.getNom_alm_padre() );
        alm_almacenDTO.setUbicacion( alm_almacen.getUbicacion() );
        alm_almacenDTO.setEstado( alm_almacen.getEstado() );

        return alm_almacenDTO;
    }

    @Override
    public Alm_almacen toEntity(Alm_almacenDTO alm_almacenDTO) {
        if ( alm_almacenDTO == null ) {
            return null;
        }

        Alm_almacen alm_almacen = new Alm_almacen();

        alm_almacen.setId( alm_almacenDTO.getId() );
        alm_almacen.setNombre( alm_almacenDTO.getNombre() );
        alm_almacen.setCod_alm_padre( alm_almacenDTO.getCod_alm_padre() );
        alm_almacen.setNom_alm_padre( alm_almacenDTO.getNom_alm_padre() );
        alm_almacen.setUbicacion( alm_almacenDTO.getUbicacion() );
        alm_almacen.setEstado( alm_almacenDTO.getEstado() );

        return alm_almacen;
    }

    @Override
    public void updateFromDto(Alm_almacenDTO dto, Alm_almacen entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getNombre() != null ) {
            entity.setNombre( dto.getNombre() );
        }
        if ( dto.getCod_alm_padre() != null ) {
            entity.setCod_alm_padre( dto.getCod_alm_padre() );
        }
        if ( dto.getNom_alm_padre() != null ) {
            entity.setNom_alm_padre( dto.getNom_alm_padre() );
        }
        if ( dto.getUbicacion() != null ) {
            entity.setUbicacion( dto.getUbicacion() );
        }
        if ( dto.getEstado() != null ) {
            entity.setEstado( dto.getEstado() );
        }
    }
}
