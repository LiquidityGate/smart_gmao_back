package com.gmao.gmao_backend.mapper.O.T;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-27T17:39:18-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class OrdenTrabajoPreventivaLegalMapperImpl implements OrdenTrabajoPreventivaLegalMapper {

    @Override
    public OrdenTrabajoPreventivaLegal toEntity(OrdenTrabajoPreventivaLegalDTO.Request dto) {
        if ( dto == null ) {
            return null;
        }

        OrdenTrabajoPreventivaLegal ordenTrabajoPreventivaLegal = new OrdenTrabajoPreventivaLegal();

        ordenTrabajoPreventivaLegal.setPeriodo( dto.getPeriodo() );
        ordenTrabajoPreventivaLegal.setOrdenesFinalizadas( dto.getOrdenesFinalizadas() );
        ordenTrabajoPreventivaLegal.setHorasRealesFinalizadas( dto.getHorasRealesFinalizadas() );
        ordenTrabajoPreventivaLegal.setHorasPrevistasFinalizadas( dto.getHorasPrevistasFinalizadas() );
        ordenTrabajoPreventivaLegal.setOrdenesPendientes( dto.getOrdenesPendientes() );
        ordenTrabajoPreventivaLegal.setHorasPrevistasPendientes( dto.getHorasPrevistasPendientes() );

        return ordenTrabajoPreventivaLegal;
    }

    @Override
    public OrdenTrabajoPreventivaLegalDTO.Response toDto(OrdenTrabajoPreventivaLegal entity) {
        if ( entity == null ) {
            return null;
        }

        OrdenTrabajoPreventivaLegalDTO.Response.ResponseBuilder response = OrdenTrabajoPreventivaLegalDTO.Response.builder();

        response.id( entity.getId() );
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
    public List<OrdenTrabajoPreventivaLegalDTO.Response> toDtoList(List<OrdenTrabajoPreventivaLegal> entities) {
        if ( entities == null ) {
            return null;
        }

        List<OrdenTrabajoPreventivaLegalDTO.Response> list = new ArrayList<OrdenTrabajoPreventivaLegalDTO.Response>( entities.size() );
        for ( OrdenTrabajoPreventivaLegal ordenTrabajoPreventivaLegal : entities ) {
            list.add( toDto( ordenTrabajoPreventivaLegal ) );
        }

        return list;
    }

    @Override
    public void updateEntityFromDto(OrdenTrabajoPreventivaLegalDTO.Request dto, OrdenTrabajoPreventivaLegal entity) {
        if ( dto == null ) {
            return;
        }

        entity.setPeriodo( dto.getPeriodo() );
        entity.setOrdenesFinalizadas( dto.getOrdenesFinalizadas() );
        entity.setHorasRealesFinalizadas( dto.getHorasRealesFinalizadas() );
        entity.setHorasPrevistasFinalizadas( dto.getHorasPrevistasFinalizadas() );
        entity.setOrdenesPendientes( dto.getOrdenesPendientes() );
        entity.setHorasPrevistasPendientes( dto.getHorasPrevistasPendientes() );
    }
}
