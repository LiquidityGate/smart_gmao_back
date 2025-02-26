package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.SalidaDTO;
import com.gmao.gmao_backend.model.Salida;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-25T14:12:09-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class SalidaMapperImpl implements SalidaMapper {

    @Override
    public SalidaDTO toDto(Salida salida) {
        if ( salida == null ) {
            return null;
        }

        SalidaDTO salidaDTO = new SalidaDTO();

        salidaDTO.setId( salida.getId() );
        salidaDTO.setNombre( salida.getNombre() );
        salidaDTO.setEstado( salida.getEstado() );

        return salidaDTO;
    }

    @Override
    public Salida toEntity(SalidaDTO salidaDTO) {
        if ( salidaDTO == null ) {
            return null;
        }

        Salida salida = new Salida();

        salida.setId( salidaDTO.getId() );
        salida.setNombre( salidaDTO.getNombre() );
        salida.setEstado( salidaDTO.getEstado() );

        return salida;
    }

    @Override
    public void updateFromDto(SalidaDTO dto, Salida entity) {
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
