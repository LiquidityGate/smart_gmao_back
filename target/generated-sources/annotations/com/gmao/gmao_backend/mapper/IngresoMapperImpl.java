package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.IngresoDTO;
import com.gmao.gmao_backend.model.Ingreso;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-25T14:12:08-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class IngresoMapperImpl implements IngresoMapper {

    @Override
    public IngresoDTO toDto(Ingreso ingreso) {
        if ( ingreso == null ) {
            return null;
        }

        IngresoDTO ingresoDTO = new IngresoDTO();

        ingresoDTO.setId( ingreso.getId() );
        ingresoDTO.setNombre( ingreso.getNombre() );
        ingresoDTO.setEstado( ingreso.getEstado() );

        return ingresoDTO;
    }

    @Override
    public Ingreso toEntity(IngresoDTO ingresoDTO) {
        if ( ingresoDTO == null ) {
            return null;
        }

        Ingreso ingreso = new Ingreso();

        ingreso.setId( ingresoDTO.getId() );
        ingreso.setNombre( ingresoDTO.getNombre() );
        ingreso.setEstado( ingresoDTO.getEstado() );

        return ingreso;
    }

    @Override
    public void updateFromDto(IngresoDTO dto, Ingreso entity) {
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
