package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.SubfamiliaDTO;
import com.gmao.gmao_backend.model.Subfamilia;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-25T14:12:10-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class SubfamiliaMapperImpl implements SubfamiliaMapper {

    @Override
    public SubfamiliaDTO toDto(Subfamilia subfamilia) {
        if ( subfamilia == null ) {
            return null;
        }

        SubfamiliaDTO subfamiliaDTO = new SubfamiliaDTO();

        subfamiliaDTO.setId( subfamilia.getId() );
        subfamiliaDTO.setNombre( subfamilia.getNombre() );
        subfamiliaDTO.setEstado( subfamilia.getEstado() );

        return subfamiliaDTO;
    }

    @Override
    public Subfamilia toEntity(SubfamiliaDTO subfamiliaDTO) {
        if ( subfamiliaDTO == null ) {
            return null;
        }

        Subfamilia subfamilia = new Subfamilia();

        subfamilia.setId( subfamiliaDTO.getId() );
        subfamilia.setNombre( subfamiliaDTO.getNombre() );
        subfamilia.setEstado( subfamiliaDTO.getEstado() );

        return subfamilia;
    }

    @Override
    public void updateFromDto(SubfamiliaDTO dto, Subfamilia entity) {
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
