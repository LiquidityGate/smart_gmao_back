package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.Alm_logDTO;
import com.gmao.gmao_backend.model.Alm_log;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-25T14:12:09-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class Alm_logMapperImpl implements Alm_logMapper {

    @Override
    public Alm_logDTO toDto(Alm_log alm_log) {
        if ( alm_log == null ) {
            return null;
        }

        Alm_logDTO alm_logDTO = new Alm_logDTO();

        alm_logDTO.setId( alm_log.getId() );
        alm_logDTO.setArticulo( alm_log.getArticulo() );
        alm_logDTO.setCategoria( alm_log.getCategoria() );
        alm_logDTO.setCod_almacen( alm_log.getCod_almacen() );
        alm_logDTO.setNom_almacen( alm_log.getNom_almacen() );
        alm_logDTO.setCantidad( alm_log.getCantidad() );
        alm_logDTO.setPrecio( alm_log.getPrecio() );
        alm_logDTO.setCod_proveedor( alm_log.getCod_proveedor() );
        alm_logDTO.setNom_proveedor( alm_log.getNom_proveedor() );
        alm_logDTO.setFecha( alm_log.getFecha() );
        alm_logDTO.setCausa( alm_log.getCausa() );

        return alm_logDTO;
    }

    @Override
    public Alm_log toEntity(Alm_logDTO alm_logDTO) {
        if ( alm_logDTO == null ) {
            return null;
        }

        Alm_log alm_log = new Alm_log();

        alm_log.setId( alm_logDTO.getId() );
        alm_log.setArticulo( alm_logDTO.getArticulo() );
        alm_log.setCategoria( alm_logDTO.getCategoria() );
        alm_log.setCod_almacen( alm_logDTO.getCod_almacen() );
        alm_log.setNom_almacen( alm_logDTO.getNom_almacen() );
        alm_log.setCantidad( alm_logDTO.getCantidad() );
        alm_log.setPrecio( alm_logDTO.getPrecio() );
        alm_log.setCod_proveedor( alm_logDTO.getCod_proveedor() );
        alm_log.setNom_proveedor( alm_logDTO.getNom_proveedor() );
        alm_log.setFecha( alm_logDTO.getFecha() );
        alm_log.setCausa( alm_logDTO.getCausa() );

        return alm_log;
    }

    @Override
    public void updateFromDto(Alm_logDTO dto, Alm_log entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getArticulo() != null ) {
            entity.setArticulo( dto.getArticulo() );
        }
        if ( dto.getCategoria() != null ) {
            entity.setCategoria( dto.getCategoria() );
        }
        if ( dto.getCod_almacen() != null ) {
            entity.setCod_almacen( dto.getCod_almacen() );
        }
        if ( dto.getNom_almacen() != null ) {
            entity.setNom_almacen( dto.getNom_almacen() );
        }
        if ( dto.getCantidad() != null ) {
            entity.setCantidad( dto.getCantidad() );
        }
        if ( dto.getPrecio() != null ) {
            entity.setPrecio( dto.getPrecio() );
        }
        if ( dto.getCod_proveedor() != null ) {
            entity.setCod_proveedor( dto.getCod_proveedor() );
        }
        if ( dto.getNom_proveedor() != null ) {
            entity.setNom_proveedor( dto.getNom_proveedor() );
        }
        if ( dto.getFecha() != null ) {
            entity.setFecha( dto.getFecha() );
        }
        if ( dto.getCausa() != null ) {
            entity.setCausa( dto.getCausa() );
        }
    }
}
