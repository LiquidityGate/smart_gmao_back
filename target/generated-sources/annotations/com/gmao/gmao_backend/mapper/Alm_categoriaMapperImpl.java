package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.Alm_categoriaDTO;
import com.gmao.gmao_backend.model.Alm_categoria;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-25T14:12:10-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class Alm_categoriaMapperImpl implements Alm_categoriaMapper {

    @Override
    public Alm_categoriaDTO toDto(Alm_categoria alm_categoria) {
        if ( alm_categoria == null ) {
            return null;
        }

        Alm_categoriaDTO alm_categoriaDTO = new Alm_categoriaDTO();

        alm_categoriaDTO.setId( alm_categoria.getId() );
        alm_categoriaDTO.setCategoria( alm_categoria.getCategoria() );
        alm_categoriaDTO.setCat_padre( alm_categoria.getCat_padre() );
        alm_categoriaDTO.setEstado( alm_categoria.getEstado() );

        return alm_categoriaDTO;
    }

    @Override
    public Alm_categoria toEntity(Alm_categoriaDTO alm_categoriaDTO) {
        if ( alm_categoriaDTO == null ) {
            return null;
        }

        Alm_categoria alm_categoria = new Alm_categoria();

        alm_categoria.setId( alm_categoriaDTO.getId() );
        alm_categoria.setCategoria( alm_categoriaDTO.getCategoria() );
        alm_categoria.setCat_padre( alm_categoriaDTO.getCat_padre() );
        alm_categoria.setEstado( alm_categoriaDTO.getEstado() );

        return alm_categoria;
    }

    @Override
    public void updateFromDto(Alm_categoriaDTO dto, Alm_categoria entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getCategoria() != null ) {
            entity.setCategoria( dto.getCategoria() );
        }
        if ( dto.getCat_padre() != null ) {
            entity.setCat_padre( dto.getCat_padre() );
        }
        if ( dto.getEstado() != null ) {
            entity.setEstado( dto.getEstado() );
        }
    }
}
