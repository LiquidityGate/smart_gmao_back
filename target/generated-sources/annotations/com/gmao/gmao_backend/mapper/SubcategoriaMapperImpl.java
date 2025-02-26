package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.SubcategoriaDTO;
import com.gmao.gmao_backend.model.Categoria;
import com.gmao.gmao_backend.model.Subcategoria;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-25T14:12:09-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class SubcategoriaMapperImpl implements SubcategoriaMapper {

    @Override
    public SubcategoriaDTO toDTO(Subcategoria subcategoria) {
        if ( subcategoria == null ) {
            return null;
        }

        SubcategoriaDTO subcategoriaDTO = new SubcategoriaDTO();

        subcategoriaDTO.setCategoriaId( subcategoriaCategoriaId( subcategoria ) );
        subcategoriaDTO.setCategoriaNombre( subcategoriaCategoriaNombre( subcategoria ) );
        subcategoriaDTO.setId( subcategoria.getId() );
        subcategoriaDTO.setNombre( subcategoria.getNombre() );
        subcategoriaDTO.setDescripcion( subcategoria.getDescripcion() );
        subcategoriaDTO.setEstado( subcategoria.getEstado() );

        return subcategoriaDTO;
    }

    @Override
    public Subcategoria toEntity(SubcategoriaDTO subcategoriaDTO) {
        if ( subcategoriaDTO == null ) {
            return null;
        }

        Subcategoria subcategoria = new Subcategoria();

        subcategoria.setCategoria( subcategoriaDTOToCategoria( subcategoriaDTO ) );
        subcategoria.setId( subcategoriaDTO.getId() );
        subcategoria.setNombre( subcategoriaDTO.getNombre() );
        subcategoria.setDescripcion( subcategoriaDTO.getDescripcion() );
        subcategoria.setEstado( subcategoriaDTO.getEstado() );

        return subcategoria;
    }

    @Override
    public void updateFromDTO(SubcategoriaDTO dto, Subcategoria entity) {
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

    private Long subcategoriaCategoriaId(Subcategoria subcategoria) {
        if ( subcategoria == null ) {
            return null;
        }
        Categoria categoria = subcategoria.getCategoria();
        if ( categoria == null ) {
            return null;
        }
        Long id = categoria.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String subcategoriaCategoriaNombre(Subcategoria subcategoria) {
        if ( subcategoria == null ) {
            return null;
        }
        Categoria categoria = subcategoria.getCategoria();
        if ( categoria == null ) {
            return null;
        }
        String nombre = categoria.getNombre();
        if ( nombre == null ) {
            return null;
        }
        return nombre;
    }

    protected Categoria subcategoriaDTOToCategoria(SubcategoriaDTO subcategoriaDTO) {
        if ( subcategoriaDTO == null ) {
            return null;
        }

        Categoria categoria = new Categoria();

        categoria.setId( subcategoriaDTO.getCategoriaId() );

        return categoria;
    }
}
