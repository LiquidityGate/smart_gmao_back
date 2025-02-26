package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.LogModulosDTO;
import com.gmao.gmao_backend.model.LogModulos;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-25T14:12:09-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class LogModulosMapperImpl implements LogModulosMapper {

    @Override
    public LogModulos toEntity(LogModulosDTO dto) {
        if ( dto == null ) {
            return null;
        }

        LogModulos logModulos = new LogModulos();

        logModulos.setId( dto.getId() );
        logModulos.setIdMenu( dto.getIdMenu() );
        logModulos.setCreadoEn( dto.getCreadoEn() );
        logModulos.setCreadoPor( dto.getCreadoPor() );

        return logModulos;
    }
}
