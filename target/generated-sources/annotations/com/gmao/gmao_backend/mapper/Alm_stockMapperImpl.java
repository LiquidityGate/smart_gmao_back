package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.Alm_stockDTO;
import com.gmao.gmao_backend.model.Alm_stock;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-25T14:12:08-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class Alm_stockMapperImpl implements Alm_stockMapper {

    @Override
    public Alm_stockDTO toDto(Alm_stock alm_stock) {
        if ( alm_stock == null ) {
            return null;
        }

        Alm_stockDTO alm_stockDTO = new Alm_stockDTO();

        alm_stockDTO.setId( alm_stock.getId() );
        alm_stockDTO.setArticulo( alm_stock.getArticulo() );
        alm_stockDTO.setCategoria( alm_stock.getCategoria() );
        alm_stockDTO.setCod_alm_padre( alm_stock.getCod_alm_padre() );
        alm_stockDTO.setNom_alm_padre( alm_stock.getNom_alm_padre() );
        alm_stockDTO.setStock_minimo( alm_stock.getStock_minimo() );
        alm_stockDTO.setStock_maximo( alm_stock.getStock_maximo() );
        alm_stockDTO.setCantidad( alm_stock.getCantidad() );

        return alm_stockDTO;
    }

    @Override
    public Alm_stock toEntity(Alm_stockDTO alm_stockDTO) {
        if ( alm_stockDTO == null ) {
            return null;
        }

        Alm_stock alm_stock = new Alm_stock();

        alm_stock.setId( alm_stockDTO.getId() );
        alm_stock.setArticulo( alm_stockDTO.getArticulo() );
        alm_stock.setCategoria( alm_stockDTO.getCategoria() );
        alm_stock.setCod_alm_padre( alm_stockDTO.getCod_alm_padre() );
        alm_stock.setNom_alm_padre( alm_stockDTO.getNom_alm_padre() );
        alm_stock.setStock_minimo( alm_stockDTO.getStock_minimo() );
        alm_stock.setStock_maximo( alm_stockDTO.getStock_maximo() );
        alm_stock.setCantidad( alm_stockDTO.getCantidad() );

        return alm_stock;
    }

    @Override
    public void updateFromDto(Alm_stockDTO dto, Alm_stock entity) {
        if ( dto == null ) {
            return;
        }

        entity.setId( dto.getId() );
        if ( dto.getArticulo() != null ) {
            entity.setArticulo( dto.getArticulo() );
        }
        if ( dto.getCategoria() != null ) {
            entity.setCategoria( dto.getCategoria() );
        }
        if ( dto.getCod_alm_padre() != null ) {
            entity.setCod_alm_padre( dto.getCod_alm_padre() );
        }
        if ( dto.getNom_alm_padre() != null ) {
            entity.setNom_alm_padre( dto.getNom_alm_padre() );
        }
        if ( dto.getStock_minimo() != null ) {
            entity.setStock_minimo( dto.getStock_minimo() );
        }
        if ( dto.getStock_maximo() != null ) {
            entity.setStock_maximo( dto.getStock_maximo() );
        }
        if ( dto.getCantidad() != null ) {
            entity.setCantidad( dto.getCantidad() );
        }
    }
}
