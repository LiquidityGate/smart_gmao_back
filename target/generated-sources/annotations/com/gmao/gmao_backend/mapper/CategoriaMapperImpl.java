package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.CategoriaDTO;
import com.gmao.gmao_backend.model.Categoria;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-25T14:12:09-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class CategoriaMapperImpl implements CategoriaMapper {

    @Override
    public CategoriaDTO toDTO(Categoria categoria) {
        if ( categoria == null ) {
            return null;
        }

        CategoriaDTO categoriaDTO = new CategoriaDTO();

        categoriaDTO.setId( categoria.getId() );
        categoriaDTO.setNombre( categoria.getNombre() );
        categoriaDTO.setDescripcion( categoria.getDescripcion() );
        categoriaDTO.setEstado( categoria.getEstado() );

        return categoriaDTO;
    }

    @Override
    public Categoria toEntity(CategoriaDTO categoriaDTO) {
        if ( categoriaDTO == null ) {
            return null;
        }

        Categoria categoria = new Categoria();

        categoria.setId( categoriaDTO.getId() );
        categoria.setNombre( categoriaDTO.getNombre() );
        categoria.setDescripcion( categoriaDTO.getDescripcion() );
        categoria.setEstado( categoriaDTO.getEstado() );

        return categoria;
    }

    @Override
    public void updateFromDTO(CategoriaDTO dto, Categoria entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getNombre() != null ) {
            entity.setNombre( dto.getNombre() );
        }
        if ( dto.getDescripcion() != null ) {
            entity.setDescripcion( dto.getDescripcion() );
        }
        if ( dto.getEstado() != null ) {
            entity.setEstado( dto.getEstado() );
        }
    }

    @Override
    public List<CategoriaDTO> toDTOList(List<Categoria> categorias) {
        if ( categorias == null ) {
            return null;
        }

        List<CategoriaDTO> list = new ArrayList<CategoriaDTO>( categorias.size() );
        for ( Categoria categoria : categorias ) {
            list.add( toDTO( categoria ) );
        }

        return list;
    }
}
