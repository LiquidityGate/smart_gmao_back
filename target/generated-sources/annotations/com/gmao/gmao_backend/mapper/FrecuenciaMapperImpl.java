package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.FrecuenciaDTO;
import com.gmao.gmao_backend.model.Frecuencia;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-25T14:12:09-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class FrecuenciaMapperImpl implements FrecuenciaMapper {

    @Override
    public FrecuenciaDTO toDTO(Frecuencia frecuencia) {
        if ( frecuencia == null ) {
            return null;
        }

        FrecuenciaDTO frecuenciaDTO = new FrecuenciaDTO();

        frecuenciaDTO.setId( frecuencia.getId() );
        frecuenciaDTO.setNombre( frecuencia.getNombre() );
        frecuenciaDTO.setDescripcion( frecuencia.getDescripcion() );
        frecuenciaDTO.setEstado( frecuencia.getEstado() );

        return frecuenciaDTO;
    }

    @Override
    public Frecuencia toEntity(FrecuenciaDTO frecuenciaDTO) {
        if ( frecuenciaDTO == null ) {
            return null;
        }

        Frecuencia frecuencia = new Frecuencia();

        frecuencia.setId( frecuenciaDTO.getId() );
        frecuencia.setNombre( frecuenciaDTO.getNombre() );
        frecuencia.setDescripcion( frecuenciaDTO.getDescripcion() );
        frecuencia.setEstado( frecuenciaDTO.getEstado() );

        return frecuencia;
    }

    @Override
    public void updateFromDTO(FrecuenciaDTO dto, Frecuencia entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getNombre() != null ) {
            entity.setNombre( dto.getNombre() );
        }
        if ( dto.getDescripcion() != null ) {
            entity.setDescripcion( dto.getDescripcion() );
        }
        if ( dto.getEstado() != null ) {
            entity.setEstado( dto.getEstado() );
        }
    }

    @Override
    public List<FrecuenciaDTO> toDTOList(List<Frecuencia> frecuencias) {
        if ( frecuencias == null ) {
            return null;
        }

        List<FrecuenciaDTO> list = new ArrayList<FrecuenciaDTO>( frecuencias.size() );
        for ( Frecuencia frecuencia : frecuencias ) {
            list.add( toDTO( frecuencia ) );
        }

        return list;
    }
}
