package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.CategoriasDTO;
import com.gmao.gmao_backend.model.Categorias;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-25T14:12:10-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class CategoriasMapperImpl implements CategoriasMapper {

    @Override
    public CategoriasDTO toDTO(Categorias categorias) {
        if ( categorias == null ) {
            return null;
        }

        CategoriasDTO categoriasDTO = new CategoriasDTO();

        categoriasDTO.setId( categorias.getId() );
        categoriasDTO.setNombre( categorias.getNombre() );
        categoriasDTO.setIdPadre( categorias.getIdPadre() );
        categoriasDTO.setNombrePadre( categorias.getNombrePadre() );
        categoriasDTO.setFechaRegistro( categorias.getFechaRegistro() );
        categoriasDTO.setEstado( categorias.getEstado() );

        return categoriasDTO;
    }

    @Override
    public Categorias toEntity(CategoriasDTO categoriasDTO) {
        if ( categoriasDTO == null ) {
            return null;
        }

        Categorias categorias = new Categorias();

        categorias.setId( categoriasDTO.getId() );
        categorias.setNombre( categoriasDTO.getNombre() );
        categorias.setIdPadre( categoriasDTO.getIdPadre() );
        categorias.setNombrePadre( categoriasDTO.getNombrePadre() );
        categorias.setFechaRegistro( categoriasDTO.getFechaRegistro() );
        categorias.setEstado( categoriasDTO.getEstado() );

        return categorias;
    }

    @Override
    public void updateFromDTO(CategoriasDTO dto, Categorias entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getNombre() != null ) {
            entity.setNombre( dto.getNombre() );
        }
        if ( dto.getIdPadre() != null ) {
            entity.setIdPadre( dto.getIdPadre() );
        }
        if ( dto.getNombrePadre() != null ) {
            entity.setNombrePadre( dto.getNombrePadre() );
        }
        if ( dto.getFechaRegistro() != null ) {
            entity.setFechaRegistro( dto.getFechaRegistro() );
        }
        if ( dto.getEstado() != null ) {
            entity.setEstado( dto.getEstado() );
        }
    }

    @Override
    public List<CategoriasDTO> toDTOList(List<Categorias> categorias) {
        if ( categorias == null ) {
            return null;
        }

        List<CategoriasDTO> list = new ArrayList<CategoriasDTO>( categorias.size() );
        for ( Categorias categorias1 : categorias ) {
            list.add( toDTO( categorias1 ) );
        }

        return list;
    }
}
