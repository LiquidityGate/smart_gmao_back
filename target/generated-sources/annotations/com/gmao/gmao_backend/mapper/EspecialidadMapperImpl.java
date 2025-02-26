package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.EspecialidadDTO;
import com.gmao.gmao_backend.model.Especialidad;
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
public class EspecialidadMapperImpl implements EspecialidadMapper {

    @Override
    public EspecialidadDTO toDTO(Especialidad especialidad) {
        if ( especialidad == null ) {
            return null;
        }

        EspecialidadDTO especialidadDTO = new EspecialidadDTO();

        especialidadDTO.setId( especialidad.getId() );
        especialidadDTO.setNombre( especialidad.getNombre() );
        especialidadDTO.setDescripcion( especialidad.getDescripcion() );
        especialidadDTO.setEstado( especialidad.getEstado() );

        return especialidadDTO;
    }

    @Override
    public Especialidad toEntity(EspecialidadDTO especialidadDTO) {
        if ( especialidadDTO == null ) {
            return null;
        }

        Especialidad especialidad = new Especialidad();

        especialidad.setId( especialidadDTO.getId() );
        especialidad.setNombre( especialidadDTO.getNombre() );
        especialidad.setDescripcion( especialidadDTO.getDescripcion() );
        especialidad.setEstado( especialidadDTO.getEstado() );

        return especialidad;
    }

    @Override
    public void updateFromDTO(EspecialidadDTO dto, Especialidad entity) {
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
    public List<EspecialidadDTO> toDTOList(List<Especialidad> especialidades) {
        if ( especialidades == null ) {
            return null;
        }

        List<EspecialidadDTO> list = new ArrayList<EspecialidadDTO>( especialidades.size() );
        for ( Especialidad especialidad : especialidades ) {
            list.add( toDTO( especialidad ) );
        }

        return list;
    }
}
