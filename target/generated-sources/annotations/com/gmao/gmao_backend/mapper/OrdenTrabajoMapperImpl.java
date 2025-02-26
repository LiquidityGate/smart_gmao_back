package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.OrdenTrabajoDTO;
import com.gmao.gmao_backend.model.AdministracionUsuariosIDName;
import com.gmao.gmao_backend.model.OrdenTrabajo;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-25T14:12:08-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class OrdenTrabajoMapperImpl implements OrdenTrabajoMapper {

    @Override
    public OrdenTrabajoDTO toDto(OrdenTrabajo ordenTrabajo) {
        if ( ordenTrabajo == null ) {
            return null;
        }

        OrdenTrabajoDTO ordenTrabajoDTO = new OrdenTrabajoDTO();

        ordenTrabajoDTO.setSolicitanteId( ordenTrabajoSolicitanteId( ordenTrabajo ) );
        ordenTrabajoDTO.setId( ordenTrabajo.getId() );
        ordenTrabajoDTO.setNumero( ordenTrabajo.getNumero() );
        ordenTrabajoDTO.setDescripcion( ordenTrabajo.getDescripcion() );
        ordenTrabajoDTO.setEstado( ordenTrabajo.getEstado() );
        ordenTrabajoDTO.setFechaApertura( ordenTrabajo.getFechaApertura() );
        ordenTrabajoDTO.setTipo( ordenTrabajo.getTipo() );
        ordenTrabajoDTO.setSitio( ordenTrabajo.getSitio() );
        ordenTrabajoDTO.setPrioridad( ordenTrabajo.getPrioridad() );
        ordenTrabajoDTO.setFechaInicioPrevisto( ordenTrabajo.getFechaInicioPrevisto() );
        ordenTrabajoDTO.setFechaFinalAsignacion( ordenTrabajo.getFechaFinalAsignacion() );
        ordenTrabajoDTO.setFechaFinalCierre( ordenTrabajo.getFechaFinalCierre() );
        ordenTrabajoDTO.setNota( ordenTrabajo.getNota() );

        ordenTrabajoDTO.setSolicitanteNombre( ordenTrabajo.getSolicitante().getNombres() + ' ' + ordenTrabajo.getSolicitante().getApellidos() );

        return ordenTrabajoDTO;
    }

    @Override
    public OrdenTrabajo toEntity(OrdenTrabajoDTO ordenTrabajoDTO) {
        if ( ordenTrabajoDTO == null ) {
            return null;
        }

        OrdenTrabajo ordenTrabajo = new OrdenTrabajo();

        ordenTrabajo.setId( ordenTrabajoDTO.getId() );
        ordenTrabajo.setNumero( ordenTrabajoDTO.getNumero() );
        ordenTrabajo.setDescripcion( ordenTrabajoDTO.getDescripcion() );
        ordenTrabajo.setEstado( ordenTrabajoDTO.getEstado() );
        ordenTrabajo.setFechaApertura( ordenTrabajoDTO.getFechaApertura() );
        ordenTrabajo.setTipo( ordenTrabajoDTO.getTipo() );
        ordenTrabajo.setSitio( ordenTrabajoDTO.getSitio() );
        ordenTrabajo.setPrioridad( ordenTrabajoDTO.getPrioridad() );
        ordenTrabajo.setFechaInicioPrevisto( ordenTrabajoDTO.getFechaInicioPrevisto() );
        ordenTrabajo.setFechaFinalAsignacion( ordenTrabajoDTO.getFechaFinalAsignacion() );
        ordenTrabajo.setFechaFinalCierre( ordenTrabajoDTO.getFechaFinalCierre() );
        ordenTrabajo.setNota( ordenTrabajoDTO.getNota() );

        return ordenTrabajo;
    }

    @Override
    public void updateFromDto(OrdenTrabajoDTO dto, OrdenTrabajo entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getNumero() != null ) {
            entity.setNumero( dto.getNumero() );
        }
        if ( dto.getDescripcion() != null ) {
            entity.setDescripcion( dto.getDescripcion() );
        }
        if ( dto.getEstado() != null ) {
            entity.setEstado( dto.getEstado() );
        }
        if ( dto.getFechaApertura() != null ) {
            entity.setFechaApertura( dto.getFechaApertura() );
        }
        if ( dto.getTipo() != null ) {
            entity.setTipo( dto.getTipo() );
        }
        if ( dto.getSitio() != null ) {
            entity.setSitio( dto.getSitio() );
        }
        if ( dto.getPrioridad() != null ) {
            entity.setPrioridad( dto.getPrioridad() );
        }
        if ( dto.getFechaInicioPrevisto() != null ) {
            entity.setFechaInicioPrevisto( dto.getFechaInicioPrevisto() );
        }
        if ( dto.getFechaFinalAsignacion() != null ) {
            entity.setFechaFinalAsignacion( dto.getFechaFinalAsignacion() );
        }
        if ( dto.getFechaFinalCierre() != null ) {
            entity.setFechaFinalCierre( dto.getFechaFinalCierre() );
        }
        if ( dto.getNota() != null ) {
            entity.setNota( dto.getNota() );
        }
    }

    private Long ordenTrabajoSolicitanteId(OrdenTrabajo ordenTrabajo) {
        if ( ordenTrabajo == null ) {
            return null;
        }
        AdministracionUsuariosIDName solicitante = ordenTrabajo.getSolicitante();
        if ( solicitante == null ) {
            return null;
        }
        Long id = solicitante.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
