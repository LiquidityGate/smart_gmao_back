package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.PrioridadDTO;
import com.gmao.gmao_backend.model.Prioridad;
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
public class PrioridadMapperImpl implements PrioridadMapper {

    @Override
    public PrioridadDTO toDTO(Prioridad prioridad) {
        if ( prioridad == null ) {
            return null;
        }

        PrioridadDTO prioridadDTO = new PrioridadDTO();

        prioridadDTO.setId( prioridad.getId() );
        prioridadDTO.setNombre( prioridad.getNombre() );
        prioridadDTO.setDescripcion( prioridad.getDescripcion() );
        prioridadDTO.setEstado( prioridad.getEstado() );

        return prioridadDTO;
    }

    @Override
    public Prioridad toEntity(PrioridadDTO prioridadDTO) {
        if ( prioridadDTO == null ) {
            return null;
        }

        Prioridad prioridad = new Prioridad();

        prioridad.setId( prioridadDTO.getId() );
        prioridad.setNombre( prioridadDTO.getNombre() );
        prioridad.setDescripcion( prioridadDTO.getDescripcion() );
        prioridad.setEstado( prioridadDTO.getEstado() );

        return prioridad;
    }

    @Override
    public void updateFromDTO(PrioridadDTO dto, Prioridad entity) {
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
    public List<PrioridadDTO> toDTOList(List<Prioridad> prioridades) {
        if ( prioridades == null ) {
            return null;
        }

        List<PrioridadDTO> list = new ArrayList<PrioridadDTO>( prioridades.size() );
        for ( Prioridad prioridad : prioridades ) {
            list.add( toDTO( prioridad ) );
        }

        return list;
    }
}
