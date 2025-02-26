package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.Configuracion.ConfiguracionActividadGestionDTO;
import com.gmao.gmao_backend.dto.Configuracion.ConfiguracionCargoDTO;
import com.gmao.gmao_backend.dto.Configuracion.ConfiguracionTipoAsignacionDTO;
import com.gmao.gmao_backend.dto.Configuracion.ConfiguracionTurnoDTO;
import com.gmao.gmao_backend.model.ActividadGestion;
import com.gmao.gmao_backend.model.Cargo;
import com.gmao.gmao_backend.model.TipoAsignacion;
import com.gmao.gmao_backend.model.Turno;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-25T14:12:10-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class ConfiguracionMapperImpl implements ConfiguracionMapper {

    @Override
    public ConfiguracionCargoDTO toDtoCargo(Cargo entity) {
        if ( entity == null ) {
            return null;
        }

        ConfiguracionCargoDTO configuracionCargoDTO = new ConfiguracionCargoDTO();

        configuracionCargoDTO.setCreadoPorId( entity.getCreadoPor() );
        configuracionCargoDTO.setActualizadoPorId( entity.getActualizadoPor() );
        configuracionCargoDTO.setId( entity.getId() );
        configuracionCargoDTO.setNombre( entity.getNombre() );
        configuracionCargoDTO.setEstado( entity.getEstado() );
        configuracionCargoDTO.setCreadoEn( entity.getCreadoEn() );
        configuracionCargoDTO.setActualizadoEn( entity.getActualizadoEn() );
        configuracionCargoDTO.setEstadoEliminado( entity.getEstadoEliminado() );

        return configuracionCargoDTO;
    }

    @Override
    public Cargo toEntityCargo(ConfiguracionCargoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Cargo cargo = new Cargo();

        cargo.setCreadoPor( dto.getCreadoPorId() );
        cargo.setActualizadoPor( dto.getActualizadoPorId() );
        cargo.setId( dto.getId() );
        cargo.setNombre( dto.getNombre() );
        cargo.setActualizadoEn( dto.getActualizadoEn() );

        return cargo;
    }

    @Override
    public void updateFromDtoCargo(ConfiguracionCargoDTO dto, Cargo entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getCreadoPorId() != null ) {
            entity.setCreadoPor( dto.getCreadoPorId() );
        }
        if ( dto.getActualizadoPorId() != null ) {
            entity.setActualizadoPor( dto.getActualizadoPorId() );
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
        if ( dto.getEstadoEliminado() != null ) {
            entity.setEstadoEliminado( dto.getEstadoEliminado() );
        }
        if ( dto.getCreadoEn() != null ) {
            entity.setCreadoEn( dto.getCreadoEn() );
        }
        if ( dto.getActualizadoEn() != null ) {
            entity.setActualizadoEn( dto.getActualizadoEn() );
        }
    }

    @Override
    public ConfiguracionTurnoDTO toDtoTurno(Turno entity) {
        if ( entity == null ) {
            return null;
        }

        ConfiguracionTurnoDTO configuracionTurnoDTO = new ConfiguracionTurnoDTO();

        configuracionTurnoDTO.setCreadoPorId( entity.getCreadoPor() );
        configuracionTurnoDTO.setActualizadoPorId( entity.getActualizadoPor() );
        configuracionTurnoDTO.setId( entity.getId() );
        configuracionTurnoDTO.setNombre( entity.getNombre() );
        configuracionTurnoDTO.setHoraEntrada( entity.getHoraEntrada() );
        configuracionTurnoDTO.setHoraSalida( entity.getHoraSalida() );
        configuracionTurnoDTO.setDiasDescanso1( entity.getDiasDescanso1() );
        configuracionTurnoDTO.setDiasDescanso2( entity.getDiasDescanso2() );
        configuracionTurnoDTO.setDiasDescanso3( entity.getDiasDescanso3() );
        configuracionTurnoDTO.setDiasDescanso4( entity.getDiasDescanso4() );
        configuracionTurnoDTO.setDiasDescanso5( entity.getDiasDescanso5() );
        configuracionTurnoDTO.setDiasDescanso6( entity.getDiasDescanso6() );
        configuracionTurnoDTO.setDiasDescanso7( entity.getDiasDescanso7() );
        configuracionTurnoDTO.setEstado( entity.getEstado() );
        configuracionTurnoDTO.setEstadoEliminado( entity.getEstadoEliminado() );
        configuracionTurnoDTO.setCreadoEn( entity.getCreadoEn() );
        configuracionTurnoDTO.setActualizadoEn( entity.getActualizadoEn() );

        return configuracionTurnoDTO;
    }

    @Override
    public Turno toEntityTurno(ConfiguracionTurnoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Turno turno = new Turno();

        turno.setCreadoPor( dto.getCreadoPorId() );
        turno.setActualizadoPor( dto.getActualizadoPorId() );
        turno.setId( dto.getId() );
        turno.setNombre( dto.getNombre() );
        turno.setHoraEntrada( dto.getHoraEntrada() );
        turno.setHoraSalida( dto.getHoraSalida() );
        turno.setDiasDescanso1( dto.getDiasDescanso1() );
        turno.setDiasDescanso2( dto.getDiasDescanso2() );
        turno.setDiasDescanso3( dto.getDiasDescanso3() );
        turno.setDiasDescanso4( dto.getDiasDescanso4() );
        turno.setDiasDescanso5( dto.getDiasDescanso5() );
        turno.setDiasDescanso6( dto.getDiasDescanso6() );
        turno.setDiasDescanso7( dto.getDiasDescanso7() );
        turno.setActualizadoEn( dto.getActualizadoEn() );

        return turno;
    }

    @Override
    public void updateFromDtoTurno(ConfiguracionTurnoDTO dto, Turno entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getCreadoPorId() != null ) {
            entity.setCreadoPor( dto.getCreadoPorId() );
        }
        if ( dto.getActualizadoPorId() != null ) {
            entity.setActualizadoPor( dto.getActualizadoPorId() );
        }
        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getNombre() != null ) {
            entity.setNombre( dto.getNombre() );
        }
        if ( dto.getHoraEntrada() != null ) {
            entity.setHoraEntrada( dto.getHoraEntrada() );
        }
        if ( dto.getHoraSalida() != null ) {
            entity.setHoraSalida( dto.getHoraSalida() );
        }
        if ( dto.getDiasDescanso1() != null ) {
            entity.setDiasDescanso1( dto.getDiasDescanso1() );
        }
        if ( dto.getDiasDescanso2() != null ) {
            entity.setDiasDescanso2( dto.getDiasDescanso2() );
        }
        if ( dto.getDiasDescanso3() != null ) {
            entity.setDiasDescanso3( dto.getDiasDescanso3() );
        }
        if ( dto.getDiasDescanso4() != null ) {
            entity.setDiasDescanso4( dto.getDiasDescanso4() );
        }
        if ( dto.getDiasDescanso5() != null ) {
            entity.setDiasDescanso5( dto.getDiasDescanso5() );
        }
        if ( dto.getDiasDescanso6() != null ) {
            entity.setDiasDescanso6( dto.getDiasDescanso6() );
        }
        if ( dto.getDiasDescanso7() != null ) {
            entity.setDiasDescanso7( dto.getDiasDescanso7() );
        }
        if ( dto.getEstado() != null ) {
            entity.setEstado( dto.getEstado() );
        }
        if ( dto.getEstadoEliminado() != null ) {
            entity.setEstadoEliminado( dto.getEstadoEliminado() );
        }
        if ( dto.getCreadoEn() != null ) {
            entity.setCreadoEn( dto.getCreadoEn() );
        }
        if ( dto.getActualizadoEn() != null ) {
            entity.setActualizadoEn( dto.getActualizadoEn() );
        }
    }

    @Override
    public ConfiguracionActividadGestionDTO toDtoActividadGestion(ActividadGestion entity) {
        if ( entity == null ) {
            return null;
        }

        ConfiguracionActividadGestionDTO configuracionActividadGestionDTO = new ConfiguracionActividadGestionDTO();

        configuracionActividadGestionDTO.setCreadoPorId( entity.getCreadoPor() );
        configuracionActividadGestionDTO.setActualizadoPorId( entity.getActualizadoPor() );
        configuracionActividadGestionDTO.setId( entity.getId() );
        configuracionActividadGestionDTO.setNombre( entity.getNombre() );
        configuracionActividadGestionDTO.setEstado( entity.getEstado() );
        configuracionActividadGestionDTO.setCreadoEn( entity.getCreadoEn() );
        configuracionActividadGestionDTO.setActualizadoEn( entity.getActualizadoEn() );
        configuracionActividadGestionDTO.setEstadoEliminado( entity.getEstadoEliminado() );

        return configuracionActividadGestionDTO;
    }

    @Override
    public ActividadGestion toEntityActividadGestion(ConfiguracionActividadGestionDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ActividadGestion actividadGestion = new ActividadGestion();

        actividadGestion.setCreadoPor( dto.getCreadoPorId() );
        actividadGestion.setActualizadoPor( dto.getActualizadoPorId() );
        actividadGestion.setId( dto.getId() );
        actividadGestion.setNombre( dto.getNombre() );
        actividadGestion.setActualizadoEn( dto.getActualizadoEn() );

        return actividadGestion;
    }

    @Override
    public void updateFromDtoActividadGestion(ConfiguracionActividadGestionDTO dto, ActividadGestion entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getCreadoPorId() != null ) {
            entity.setCreadoPor( dto.getCreadoPorId() );
        }
        if ( dto.getActualizadoPorId() != null ) {
            entity.setActualizadoPor( dto.getActualizadoPorId() );
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
        if ( dto.getCreadoEn() != null ) {
            entity.setCreadoEn( dto.getCreadoEn() );
        }
        if ( dto.getActualizadoEn() != null ) {
            entity.setActualizadoEn( dto.getActualizadoEn() );
        }
        if ( dto.getEstadoEliminado() != null ) {
            entity.setEstadoEliminado( dto.getEstadoEliminado() );
        }
    }

    @Override
    public ConfiguracionTipoAsignacionDTO toDtoTipoAsignacion(TipoAsignacion entity) {
        if ( entity == null ) {
            return null;
        }

        ConfiguracionTipoAsignacionDTO configuracionTipoAsignacionDTO = new ConfiguracionTipoAsignacionDTO();

        configuracionTipoAsignacionDTO.setCreadoPorId( entity.getCreadoPor() );
        configuracionTipoAsignacionDTO.setActualizadoPorId( entity.getActualizadoPor() );
        configuracionTipoAsignacionDTO.setId( entity.getId() );
        configuracionTipoAsignacionDTO.setNombre( entity.getNombre() );
        configuracionTipoAsignacionDTO.setEstado( entity.getEstado() );
        configuracionTipoAsignacionDTO.setCreadoEn( entity.getCreadoEn() );
        configuracionTipoAsignacionDTO.setActualizadoEn( entity.getActualizadoEn() );
        configuracionTipoAsignacionDTO.setEstadoEliminado( entity.getEstadoEliminado() );

        return configuracionTipoAsignacionDTO;
    }

    @Override
    public TipoAsignacion toEntityTipoAsignacion(ConfiguracionTipoAsignacionDTO dto) {
        if ( dto == null ) {
            return null;
        }

        TipoAsignacion tipoAsignacion = new TipoAsignacion();

        tipoAsignacion.setCreadoPor( dto.getCreadoPorId() );
        tipoAsignacion.setActualizadoPor( dto.getActualizadoPorId() );
        tipoAsignacion.setId( dto.getId() );
        tipoAsignacion.setNombre( dto.getNombre() );
        tipoAsignacion.setActualizadoEn( dto.getActualizadoEn() );

        return tipoAsignacion;
    }

    @Override
    public void updateFromDtoTipoAsignacion(ConfiguracionTipoAsignacionDTO dto, TipoAsignacion entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getCreadoPorId() != null ) {
            entity.setCreadoPor( dto.getCreadoPorId() );
        }
        if ( dto.getActualizadoPorId() != null ) {
            entity.setActualizadoPor( dto.getActualizadoPorId() );
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
        if ( dto.getCreadoEn() != null ) {
            entity.setCreadoEn( dto.getCreadoEn() );
        }
        if ( dto.getActualizadoEn() != null ) {
            entity.setActualizadoEn( dto.getActualizadoEn() );
        }
        if ( dto.getEstadoEliminado() != null ) {
            entity.setEstadoEliminado( dto.getEstadoEliminado() );
        }
    }
}
