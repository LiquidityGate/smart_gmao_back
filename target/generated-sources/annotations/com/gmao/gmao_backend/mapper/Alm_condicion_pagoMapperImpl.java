package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.Alm_condicion_pagoDTO;
import com.gmao.gmao_backend.model.Alm_condicion_pago;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-25T14:12:09-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class Alm_condicion_pagoMapperImpl implements Alm_condicion_pagoMapper {

    @Override
    public Alm_condicion_pagoDTO toDto(Alm_condicion_pago alm_condicion_pago) {
        if ( alm_condicion_pago == null ) {
            return null;
        }

        Alm_condicion_pagoDTO alm_condicion_pagoDTO = new Alm_condicion_pagoDTO();

        alm_condicion_pagoDTO.setId( alm_condicion_pago.getId() );
        alm_condicion_pagoDTO.setNombre( alm_condicion_pago.getNombre() );
        alm_condicion_pagoDTO.setEstado( alm_condicion_pago.getEstado() );

        return alm_condicion_pagoDTO;
    }

    @Override
    public Alm_condicion_pago toEntity(Alm_condicion_pagoDTO alm_condicion_pagoDTO) {
        if ( alm_condicion_pagoDTO == null ) {
            return null;
        }

        Alm_condicion_pago alm_condicion_pago = new Alm_condicion_pago();

        alm_condicion_pago.setId( alm_condicion_pagoDTO.getId() );
        alm_condicion_pago.setNombre( alm_condicion_pagoDTO.getNombre() );
        alm_condicion_pago.setEstado( alm_condicion_pagoDTO.getEstado() );

        return alm_condicion_pago;
    }

    @Override
    public void updateFromDto(Alm_condicion_pagoDTO dto, Alm_condicion_pago entity) {
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
