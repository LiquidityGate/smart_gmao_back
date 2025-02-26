package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.Usu_turnoDTO;
import com.gmao.gmao_backend.model.Usu_turno;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-25T14:12:09-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class Usu_turnoMapperImpl implements Usu_turnoMapper {

    @Override
    public Usu_turnoDTO toDto(Usu_turno usu_turno) {
        if ( usu_turno == null ) {
            return null;
        }

        Usu_turnoDTO usu_turnoDTO = new Usu_turnoDTO();

        usu_turnoDTO.setId( usu_turno.getId() );
        usu_turnoDTO.setTurno( usu_turno.getTurno() );
        usu_turnoDTO.setHorario( usu_turno.getHorario() );
        usu_turnoDTO.setDescanso( usu_turno.getDescanso() );
        usu_turnoDTO.setEstado( usu_turno.getEstado() );

        return usu_turnoDTO;
    }

    @Override
    public Usu_turno toEntity(Usu_turnoDTO usu_turnoDTO) {
        if ( usu_turnoDTO == null ) {
            return null;
        }

        Usu_turno usu_turno = new Usu_turno();

        usu_turno.setId( usu_turnoDTO.getId() );
        usu_turno.setTurno( usu_turnoDTO.getTurno() );
        usu_turno.setHorario( usu_turnoDTO.getHorario() );
        usu_turno.setDescanso( usu_turnoDTO.getDescanso() );
        usu_turno.setEstado( usu_turnoDTO.getEstado() );

        return usu_turno;
    }

    @Override
    public void updateFromDto(Usu_turnoDTO dto, Usu_turno entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getTurno() != null ) {
            entity.setTurno( dto.getTurno() );
        }
        if ( dto.getHorario() != null ) {
            entity.setHorario( dto.getHorario() );
        }
        if ( dto.getDescanso() != null ) {
            entity.setDescanso( dto.getDescanso() );
        }
        if ( dto.getEstado() != null ) {
            entity.setEstado( dto.getEstado() );
        }
    }
}
