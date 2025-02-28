package com.gmao.gmao_backend.mapper.O.T;

import com.gmao.gmao_backend.dto.O.T.OrdenesTrabajoDTO;
import com.gmao.gmao_backend.model.O.T.OrdenesTrabajo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-28T13:42:16-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class OrdenesTrabajoMapperImpl implements OrdenesTrabajoMapper {

    @Override
    public OrdenesTrabajo toEntity(OrdenesTrabajoDTO.Request dto) {
        if ( dto == null ) {
            return null;
        }

        OrdenesTrabajo ordenesTrabajo = new OrdenesTrabajo();

        ordenesTrabajo.setTipo( dto.getTipo() );
        ordenesTrabajo.setPeriodo( dto.getPeriodo() );
        ordenesTrabajo.setOrdenesFinalizadas( dto.getOrdenesFinalizadas() );
        ordenesTrabajo.setHorasRealesFinalizadas( dto.getHorasRealesFinalizadas() );
        ordenesTrabajo.setHorasPrevistasFinalizadas( dto.getHorasPrevistasFinalizadas() );
        ordenesTrabajo.setOrdenesPendientes( dto.getOrdenesPendientes() );
        ordenesTrabajo.setHorasPrevistasPendientes( dto.getHorasPrevistasPendientes() );

        return ordenesTrabajo;
    }

    @Override
    public OrdenesTrabajoDTO.Response toDto(OrdenesTrabajo entity) {
        if ( entity == null ) {
            return null;
        }

        OrdenesTrabajoDTO.Response.ResponseBuilder response = OrdenesTrabajoDTO.Response.builder();

        response.id( entity.getId() );
        response.tipo( entity.getTipo() );
        response.periodo( entity.getPeriodo() );
        response.ordenesFinalizadas( entity.getOrdenesFinalizadas() );
        response.horasRealesFinalizadas( entity.getHorasRealesFinalizadas() );
        response.horasPrevistasFinalizadas( entity.getHorasPrevistasFinalizadas() );
        response.ordenesPendientes( entity.getOrdenesPendientes() );
        response.horasPrevistasPendientes( entity.getHorasPrevistasPendientes() );
        response.fechaActualizacion( entity.getFechaActualizacion() );

        response.porcentajeCumplimiento( entity.getPorcentajeCumplimiento() );
        response.desviacionHoras( entity.getDesviacionHoras() );
        response.eficiencia( entity.getEficiencia() );
        response.tiempoMedioPorOrden( entity.getTiempoMedioPorOrden() );
        response.totalHoras( entity.getTotalHoras() );

        return response.build();
    }

    @Override
    public List<OrdenesTrabajoDTO.Response> toDtoList(List<OrdenesTrabajo> entities) {
        if ( entities == null ) {
            return null;
        }

        List<OrdenesTrabajoDTO.Response> list = new ArrayList<OrdenesTrabajoDTO.Response>( entities.size() );
        for ( OrdenesTrabajo ordenesTrabajo : entities ) {
            list.add( toDto( ordenesTrabajo ) );
        }

        return list;
    }

    @Override
    public void updateEntityFromDto(OrdenesTrabajoDTO.Request dto, OrdenesTrabajo entity) {
        if ( dto == null ) {
            return;
        }

        entity.setTipo( dto.getTipo() );
        entity.setPeriodo( dto.getPeriodo() );
        entity.setOrdenesFinalizadas( dto.getOrdenesFinalizadas() );
        entity.setHorasRealesFinalizadas( dto.getHorasRealesFinalizadas() );
        entity.setHorasPrevistasFinalizadas( dto.getHorasPrevistasFinalizadas() );
        entity.setOrdenesPendientes( dto.getOrdenesPendientes() );
        entity.setHorasPrevistasPendientes( dto.getHorasPrevistasPendientes() );
    }
}
