package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.ArticuloDTO;
import com.gmao.gmao_backend.model.Articulo;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-25T14:12:09-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class ArticuloMapperImpl implements ArticuloMapper {

    @Override
    public ArticuloDTO toDto(Articulo articulo) {
        if ( articulo == null ) {
            return null;
        }

        ArticuloDTO articuloDTO = new ArticuloDTO();

        articuloDTO.setId( articulo.getId() );
        articuloDTO.setId_familias( articulo.getId_familias() );
        articuloDTO.setId_subfamilia( articulo.getId_subfamilia() );
        articuloDTO.setNombre_art( articulo.getNombre_art() );
        articuloDTO.setId_marcas( articulo.getId_marcas() );
        articuloDTO.setCoste_ultimo( articulo.getCoste_ultimo() );
        articuloDTO.setStock_total( articulo.getStock_total() );
        articuloDTO.setPeso( articulo.getPeso() );
        articuloDTO.setLargo( articulo.getLargo() );
        articuloDTO.setAncho( articulo.getAncho() );
        articuloDTO.setAlto( articulo.getAlto() );
        articuloDTO.setNombre_imagen( articulo.getNombre_imagen() );
        articuloDTO.setEstado( articulo.getEstado() );

        return articuloDTO;
    }

    @Override
    public Articulo toEntity(ArticuloDTO articuloDTO) {
        if ( articuloDTO == null ) {
            return null;
        }

        Articulo articulo = new Articulo();

        articulo.setId( articuloDTO.getId() );
        articulo.setId_familias( articuloDTO.getId_familias() );
        articulo.setId_subfamilia( articuloDTO.getId_subfamilia() );
        articulo.setNombre_art( articuloDTO.getNombre_art() );
        articulo.setId_marcas( articuloDTO.getId_marcas() );
        articulo.setCoste_ultimo( articuloDTO.getCoste_ultimo() );
        articulo.setStock_total( articuloDTO.getStock_total() );
        articulo.setPeso( articuloDTO.getPeso() );
        articulo.setLargo( articuloDTO.getLargo() );
        articulo.setAncho( articuloDTO.getAncho() );
        articulo.setAlto( articuloDTO.getAlto() );
        articulo.setNombre_imagen( articuloDTO.getNombre_imagen() );
        articulo.setEstado( articuloDTO.getEstado() );

        return articulo;
    }

    @Override
    public void updateFromDto(ArticuloDTO dto, Articulo entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getId_familias() != null ) {
            entity.setId_familias( dto.getId_familias() );
        }
        if ( dto.getId_subfamilia() != null ) {
            entity.setId_subfamilia( dto.getId_subfamilia() );
        }
        if ( dto.getNombre_art() != null ) {
            entity.setNombre_art( dto.getNombre_art() );
        }
        if ( dto.getId_marcas() != null ) {
            entity.setId_marcas( dto.getId_marcas() );
        }
        if ( dto.getCoste_ultimo() != null ) {
            entity.setCoste_ultimo( dto.getCoste_ultimo() );
        }
        if ( dto.getStock_total() != null ) {
            entity.setStock_total( dto.getStock_total() );
        }
        if ( dto.getPeso() != null ) {
            entity.setPeso( dto.getPeso() );
        }
        if ( dto.getLargo() != null ) {
            entity.setLargo( dto.getLargo() );
        }
        if ( dto.getAncho() != null ) {
            entity.setAncho( dto.getAncho() );
        }
        if ( dto.getAlto() != null ) {
            entity.setAlto( dto.getAlto() );
        }
        if ( dto.getNombre_imagen() != null ) {
            entity.setNombre_imagen( dto.getNombre_imagen() );
        }
        if ( dto.getEstado() != null ) {
            entity.setEstado( dto.getEstado() );
        }
    }
}
