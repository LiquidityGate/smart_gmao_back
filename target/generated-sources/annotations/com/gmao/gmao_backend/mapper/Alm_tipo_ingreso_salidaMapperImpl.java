package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.Alm_tipo_ingreso_salidaDTO;
import com.gmao.gmao_backend.model.Alm_tipo_ingreso_salida;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-25T14:12:09-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class Alm_tipo_ingreso_salidaMapperImpl implements Alm_tipo_ingreso_salidaMapper {

    @Override
    public Alm_tipo_ingreso_salidaDTO toDto(Alm_tipo_ingreso_salida alm_tipo_ingreso_salida) {
        if ( alm_tipo_ingreso_salida == null ) {
            return null;
        }

        Alm_tipo_ingreso_salidaDTO alm_tipo_ingreso_salidaDTO = new Alm_tipo_ingreso_salidaDTO();

        alm_tipo_ingreso_salidaDTO.setId( alm_tipo_ingreso_salida.getId() );
        alm_tipo_ingreso_salidaDTO.setNombre( alm_tipo_ingreso_salida.getNombre() );
        alm_tipo_ingreso_salidaDTO.setEstado( alm_tipo_ingreso_salida.getEstado() );

        return alm_tipo_ingreso_salidaDTO;
    }

    @Override
    public Alm_tipo_ingreso_salida toEntity(Alm_tipo_ingreso_salidaDTO alm_tipo_ingreso_salidaDTO) {
        if ( alm_tipo_ingreso_salidaDTO == null ) {
            return null;
        }

        Alm_tipo_ingreso_salida alm_tipo_ingreso_salida = new Alm_tipo_ingreso_salida();

        alm_tipo_ingreso_salida.setId( alm_tipo_ingreso_salidaDTO.getId() );
        alm_tipo_ingreso_salida.setNombre( alm_tipo_ingreso_salidaDTO.getNombre() );
        alm_tipo_ingreso_salida.setEstado( alm_tipo_ingreso_salidaDTO.getEstado() );

        return alm_tipo_ingreso_salida;
    }

    @Override
    public void updateFromDto(Alm_tipo_ingreso_salidaDTO dto, Alm_tipo_ingreso_salida entity) {
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
