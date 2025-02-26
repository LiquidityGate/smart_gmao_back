package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.OrdenCompraDTO;
import com.gmao.gmao_backend.model.OrdenCompra;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-25T14:12:09-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class OrdenCompraMapperImpl implements OrdenCompraMapper {

    @Override
    public OrdenCompraDTO toDto(OrdenCompra ordenCompra) {
        if ( ordenCompra == null ) {
            return null;
        }

        OrdenCompraDTO ordenCompraDTO = new OrdenCompraDTO();

        ordenCompraDTO.setId( ordenCompra.getId() );
        ordenCompraDTO.setNombre( ordenCompra.getNombre() );
        ordenCompraDTO.setEstado( ordenCompra.getEstado() );

        return ordenCompraDTO;
    }

    @Override
    public OrdenCompra toEntity(OrdenCompraDTO ordenCompraDTO) {
        if ( ordenCompraDTO == null ) {
            return null;
        }

        OrdenCompra ordenCompra = new OrdenCompra();

        ordenCompra.setId( ordenCompraDTO.getId() );
        ordenCompra.setNombre( ordenCompraDTO.getNombre() );
        ordenCompra.setEstado( ordenCompraDTO.getEstado() );

        return ordenCompra;
    }

    @Override
    public void updateFromDto(OrdenCompraDTO dto, OrdenCompra entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getNombre() != null ) {
            entity.setNombre( dto.getNombre() );
        }
        if ( dto.getEstado() != null ) {
            entity.setEstado( dto.getEstado() );
        }
    }
}
