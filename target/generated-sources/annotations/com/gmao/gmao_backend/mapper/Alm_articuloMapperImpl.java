package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.Alm_articuloDTO;
import com.gmao.gmao_backend.model.Alm_articulo;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-25T14:12:09-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class Alm_articuloMapperImpl implements Alm_articuloMapper {

    @Override
    public Alm_articuloDTO toDto(Alm_articulo alm_articulo) {
        if ( alm_articulo == null ) {
            return null;
        }

        Alm_articuloDTO alm_articuloDTO = new Alm_articuloDTO();

        alm_articuloDTO.setId( alm_articulo.getId() );
        alm_articuloDTO.setNombre( alm_articulo.getNombre() );
        alm_articuloDTO.setProveedor( alm_articulo.getProveedor() );
        alm_articuloDTO.setFabricante( alm_articulo.getFabricante() );
        alm_articuloDTO.setMarca( alm_articulo.getMarca() );
        alm_articuloDTO.setModelo( alm_articulo.getModelo() );
        alm_articuloDTO.setStock_minimo( alm_articulo.getStock_minimo() );
        alm_articuloDTO.setStock_maximo( alm_articulo.getStock_maximo() );
        alm_articuloDTO.setEstado( alm_articulo.getEstado() );

        return alm_articuloDTO;
    }

    @Override
    public Alm_articulo toEntity(Alm_articuloDTO alm_articuloDTO) {
        if ( alm_articuloDTO == null ) {
            return null;
        }

        Alm_articulo alm_articulo = new Alm_articulo();

        alm_articulo.setId( alm_articuloDTO.getId() );
        alm_articulo.setNombre( alm_articuloDTO.getNombre() );
        alm_articulo.setProveedor( alm_articuloDTO.getProveedor() );
        alm_articulo.setFabricante( alm_articuloDTO.getFabricante() );
        alm_articulo.setMarca( alm_articuloDTO.getMarca() );
        alm_articulo.setModelo( alm_articuloDTO.getModelo() );
        alm_articulo.setStock_minimo( alm_articuloDTO.getStock_minimo() );
        alm_articulo.setStock_maximo( alm_articuloDTO.getStock_maximo() );
        alm_articulo.setEstado( alm_articuloDTO.getEstado() );

        return alm_articulo;
    }

    @Override
    public void updateFromDto(Alm_articuloDTO dto, Alm_articulo entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getNombre() != null ) {
            entity.setNombre( dto.getNombre() );
        }
        if ( dto.getProveedor() != null ) {
            entity.setProveedor( dto.getProveedor() );
        }
        if ( dto.getFabricante() != null ) {
            entity.setFabricante( dto.getFabricante() );
        }
        if ( dto.getMarca() != null ) {
            entity.setMarca( dto.getMarca() );
        }
        if ( dto.getModelo() != null ) {
            entity.setModelo( dto.getModelo() );
        }
        if ( dto.getStock_minimo() != null ) {
            entity.setStock_minimo( dto.getStock_minimo() );
        }
        if ( dto.getStock_maximo() != null ) {
            entity.setStock_maximo( dto.getStock_maximo() );
        }
        if ( dto.getEstado() != null ) {
            entity.setEstado( dto.getEstado() );
        }
    }
}
