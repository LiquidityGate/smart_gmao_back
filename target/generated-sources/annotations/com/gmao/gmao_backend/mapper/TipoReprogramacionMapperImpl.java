package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.TipoReprogramacionDTO;
import com.gmao.gmao_backend.model.TipoReprogramacion;
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
public class TipoReprogramacionMapperImpl implements TipoReprogramacionMapper {

    @Override
    public TipoReprogramacionDTO toDTO(TipoReprogramacion tipoReprogramacion) {
        if ( tipoReprogramacion == null ) {
            return null;
        }

        TipoReprogramacionDTO tipoReprogramacionDTO = new TipoReprogramacionDTO();

        tipoReprogramacionDTO.setId( tipoReprogramacion.getId() );
        tipoReprogramacionDTO.setNombre( tipoReprogramacion.getNombre() );
        tipoReprogramacionDTO.setDescripcion( tipoReprogramacion.getDescripcion() );
        tipoReprogramacionDTO.setEstado( tipoReprogramacion.getEstado() );
        tipoReprogramacionDTO.setFechaCreacion( tipoReprogramacion.getFechaCreacion() );

        return tipoReprogramacionDTO;
    }

    @Override
    public TipoReprogramacion toEntity(TipoReprogramacionDTO tipoReprogramacionDTO) {
        if ( tipoReprogramacionDTO == null ) {
            return null;
        }

        TipoReprogramacion tipoReprogramacion = new TipoReprogramacion();

        tipoReprogramacion.setId( tipoReprogramacionDTO.getId() );
        tipoReprogramacion.setNombre( tipoReprogramacionDTO.getNombre() );
        tipoReprogramacion.setDescripcion( tipoReprogramacionDTO.getDescripcion() );
        tipoReprogramacion.setEstado( tipoReprogramacionDTO.getEstado() );
        tipoReprogramacion.setFechaCreacion( tipoReprogramacionDTO.getFechaCreacion() );

        return tipoReprogramacion;
    }

    @Override
    public void updateFromDTO(TipoReprogramacionDTO dto, TipoReprogramacion entity) {
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
        if ( dto.getFechaCreacion() != null ) {
            entity.setFechaCreacion( dto.getFechaCreacion() );
        }
    }

    @Override
    public List<TipoReprogramacionDTO> toDTOList(List<TipoReprogramacion> tipoReprogramaciones) {
        if ( tipoReprogramaciones == null ) {
            return null;
        }

        List<TipoReprogramacionDTO> list = new ArrayList<TipoReprogramacionDTO>( tipoReprogramaciones.size() );
        for ( TipoReprogramacion tipoReprogramacion : tipoReprogramaciones ) {
            list.add( toDTO( tipoReprogramacion ) );
        }

        return list;
    }
}
