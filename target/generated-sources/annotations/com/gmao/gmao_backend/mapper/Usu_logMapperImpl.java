package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.Usu_logDTO;
import com.gmao.gmao_backend.model.Usu_log;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-25T14:12:09-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class Usu_logMapperImpl implements Usu_logMapper {

    @Override
    public Usu_logDTO toDto(Usu_log usu_log) {
        if ( usu_log == null ) {
            return null;
        }

        Usu_logDTO usu_logDTO = new Usu_logDTO();

        usu_logDTO.setId( usu_log.getId() );
        usu_logDTO.setUsuario( usu_log.getUsuario() );
        usu_logDTO.setNombres( usu_log.getNombres() );
        usu_logDTO.setApellidos( usu_log.getApellidos() );
        usu_logDTO.setFecha_ult_conexion( usu_log.getFecha_ult_conexion() );
        usu_logDTO.setNro( usu_log.getNro() );

        return usu_logDTO;
    }

    @Override
    public Usu_log toEntity(Usu_logDTO usu_logDTO) {
        if ( usu_logDTO == null ) {
            return null;
        }

        Usu_log usu_log = new Usu_log();

        usu_log.setId( usu_logDTO.getId() );
        usu_log.setUsuario( usu_logDTO.getUsuario() );
        usu_log.setNombres( usu_logDTO.getNombres() );
        usu_log.setApellidos( usu_logDTO.getApellidos() );
        usu_log.setFecha_ult_conexion( usu_logDTO.getFecha_ult_conexion() );
        usu_log.setNro( usu_logDTO.getNro() );

        return usu_log;
    }

    @Override
    public void updateFromDto(Usu_logDTO dto, Usu_log entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getUsuario() != null ) {
            entity.setUsuario( dto.getUsuario() );
        }
        if ( dto.getNombres() != null ) {
            entity.setNombres( dto.getNombres() );
        }
        if ( dto.getApellidos() != null ) {
            entity.setApellidos( dto.getApellidos() );
        }
        if ( dto.getFecha_ult_conexion() != null ) {
            entity.setFecha_ult_conexion( dto.getFecha_ult_conexion() );
        }
        if ( dto.getNro() != null ) {
            entity.setNro( dto.getNro() );
        }
    }
}
