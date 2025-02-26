package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.FamiliaDTO;
import com.gmao.gmao_backend.model.Familia;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-25T14:12:10-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class FamiliaMapperImpl implements FamiliaMapper {

    @Override
    public FamiliaDTO toDto(Familia familia) {
        if ( familia == null ) {
            return null;
        }

        FamiliaDTO familiaDTO = new FamiliaDTO();

        familiaDTO.setId( familia.getId() );
        familiaDTO.setNombre( familia.getNombre() );
        familiaDTO.setEstado( familia.getEstado() );

        return familiaDTO;
    }

    @Override
    public Familia toEntity(FamiliaDTO familiaDTO) {
        if ( familiaDTO == null ) {
            return null;
        }

        Familia familia = new Familia();

        familia.setId( familiaDTO.getId() );
        familia.setNombre( familiaDTO.getNombre() );
        familia.setEstado( familiaDTO.getEstado() );

        return familia;
    }

    @Override
    public void updateFromDto(FamiliaDTO dto, Familia entity) {
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
