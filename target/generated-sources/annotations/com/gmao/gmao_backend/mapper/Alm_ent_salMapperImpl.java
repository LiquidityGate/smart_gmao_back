package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.Alm_ent_salDTO;
import com.gmao.gmao_backend.model.Alm_ent_sal;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-25T14:12:10-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class Alm_ent_salMapperImpl implements Alm_ent_salMapper {

    @Override
    public Alm_ent_salDTO toDto(Alm_ent_sal alm_ent_sal) {
        if ( alm_ent_sal == null ) {
            return null;
        }

        Alm_ent_salDTO alm_ent_salDTO = new Alm_ent_salDTO();

        alm_ent_salDTO.setId( alm_ent_sal.getId() );
        alm_ent_salDTO.setArticulo( alm_ent_sal.getArticulo() );
        alm_ent_salDTO.setCod_alm_padre( alm_ent_sal.getCod_alm_padre() );
        alm_ent_salDTO.setNom_alm_padre( alm_ent_sal.getNom_alm_padre() );
        alm_ent_salDTO.setProveedor( alm_ent_sal.getProveedor() );
        alm_ent_salDTO.setCant_entrada( alm_ent_sal.getCant_entrada() );
        alm_ent_salDTO.setPrecio_total( alm_ent_sal.getPrecio_total() );
        alm_ent_salDTO.setEstado( alm_ent_sal.getEstado() );

        return alm_ent_salDTO;
    }

    @Override
    public Alm_ent_sal toEntity(Alm_ent_salDTO alm_ent_salDTO) {
        if ( alm_ent_salDTO == null ) {
            return null;
        }

        Alm_ent_sal alm_ent_sal = new Alm_ent_sal();

        alm_ent_sal.setId( alm_ent_salDTO.getId() );
        alm_ent_sal.setArticulo( alm_ent_salDTO.getArticulo() );
        alm_ent_sal.setCod_alm_padre( alm_ent_salDTO.getCod_alm_padre() );
        alm_ent_sal.setNom_alm_padre( alm_ent_salDTO.getNom_alm_padre() );
        alm_ent_sal.setProveedor( alm_ent_salDTO.getProveedor() );
        alm_ent_sal.setCant_entrada( alm_ent_salDTO.getCant_entrada() );
        alm_ent_sal.setPrecio_total( alm_ent_salDTO.getPrecio_total() );
        alm_ent_sal.setEstado( alm_ent_salDTO.getEstado() );

        return alm_ent_sal;
    }

    @Override
    public void updateFromDto(Alm_ent_salDTO dto, Alm_ent_sal entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getArticulo() != null ) {
            entity.setArticulo( dto.getArticulo() );
        }
        if ( dto.getCod_alm_padre() != null ) {
            entity.setCod_alm_padre( dto.getCod_alm_padre() );
        }
        if ( dto.getNom_alm_padre() != null ) {
            entity.setNom_alm_padre( dto.getNom_alm_padre() );
        }
        if ( dto.getProveedor() != null ) {
            entity.setProveedor( dto.getProveedor() );
        }
        if ( dto.getCant_entrada() != null ) {
            entity.setCant_entrada( dto.getCant_entrada() );
        }
        if ( dto.getPrecio_total() != null ) {
            entity.setPrecio_total( dto.getPrecio_total() );
        }
        if ( dto.getEstado() != null ) {
            entity.setEstado( dto.getEstado() );
        }
    }
}
