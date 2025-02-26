package com.gmao.gmao_backend.mapper.MvAutogestion;

import com.gmao.gmao_backend.dto.MvAutogestion.MvaFeedbackux.MvaFeedbackuxTablaDTO;
import com.gmao.gmao_backend.model.MvaFeedbackux;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-24T17:42:28-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class MvaFeedbackuxMapperImpl implements MvaFeedbackuxMapper {

    @Override
    public MvaFeedbackuxTablaDTO toDtoTabla(MvaFeedbackux usuario) {
        if ( usuario == null ) {
            return null;
        }

        MvaFeedbackuxTablaDTO mvaFeedbackuxTablaDTO = new MvaFeedbackuxTablaDTO();

        mvaFeedbackuxTablaDTO.setId( usuario.getId() );
        mvaFeedbackuxTablaDTO.setUrl( usuario.getUrl() );
        mvaFeedbackuxTablaDTO.setArchivoImg( usuario.getArchivoImg() );
        mvaFeedbackuxTablaDTO.setDescripcion( usuario.getDescripcion() );
        mvaFeedbackuxTablaDTO.setOtros( usuario.getOtros() );
        mvaFeedbackuxTablaDTO.setSatisfaccionUx( usuario.getSatisfaccionUx() );
        mvaFeedbackuxTablaDTO.setNavegacionUx( usuario.getNavegacionUx() );
        mvaFeedbackuxTablaDTO.setVisualUx( usuario.getVisualUx() );
        mvaFeedbackuxTablaDTO.setInformacionUx( usuario.getInformacionUx() );
        mvaFeedbackuxTablaDTO.setRespuesta( usuario.getRespuesta() );
        mvaFeedbackuxTablaDTO.setAtencion( usuario.getAtencion() );
        mvaFeedbackuxTablaDTO.setEstado( usuario.getEstado() );
        mvaFeedbackuxTablaDTO.setCreadoEn( usuario.getCreadoEn() );
        if ( usuario.getCreadoPor() != null ) {
            mvaFeedbackuxTablaDTO.setCreadoPor( String.valueOf( usuario.getCreadoPor() ) );
        }

        return mvaFeedbackuxTablaDTO;
    }

    @Override
    public MvaFeedbackux toEntityTabla(MvaFeedbackuxTablaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        MvaFeedbackux mvaFeedbackux = new MvaFeedbackux();

        mvaFeedbackux.setId( dto.getId() );
        mvaFeedbackux.setUrl( dto.getUrl() );
        mvaFeedbackux.setArchivoImg( dto.getArchivoImg() );
        mvaFeedbackux.setDescripcion( dto.getDescripcion() );
        mvaFeedbackux.setOtros( dto.getOtros() );
        mvaFeedbackux.setSatisfaccionUx( dto.getSatisfaccionUx() );
        mvaFeedbackux.setNavegacionUx( dto.getNavegacionUx() );
        mvaFeedbackux.setVisualUx( dto.getVisualUx() );
        mvaFeedbackux.setInformacionUx( dto.getInformacionUx() );
        mvaFeedbackux.setRespuesta( dto.getRespuesta() );
        mvaFeedbackux.setAtencion( dto.getAtencion() );
        mvaFeedbackux.setEstado( dto.getEstado() );
        mvaFeedbackux.setCreadoEn( dto.getCreadoEn() );
        if ( dto.getCreadoPor() != null ) {
            mvaFeedbackux.setCreadoPor( Long.parseLong( dto.getCreadoPor() ) );
        }

        return mvaFeedbackux;
    }

    @Override
    public void updateFromDto(MvaFeedbackuxTablaDTO dto, MvaFeedbackux entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getUrl() != null ) {
            entity.setUrl( dto.getUrl() );
        }
        if ( dto.getArchivoImg() != null ) {
            entity.setArchivoImg( dto.getArchivoImg() );
        }
        if ( dto.getDescripcion() != null ) {
            entity.setDescripcion( dto.getDescripcion() );
        }
        if ( dto.getOtros() != null ) {
            entity.setOtros( dto.getOtros() );
        }
        if ( dto.getSatisfaccionUx() != null ) {
            entity.setSatisfaccionUx( dto.getSatisfaccionUx() );
        }
        if ( dto.getNavegacionUx() != null ) {
            entity.setNavegacionUx( dto.getNavegacionUx() );
        }
        if ( dto.getVisualUx() != null ) {
            entity.setVisualUx( dto.getVisualUx() );
        }
        if ( dto.getInformacionUx() != null ) {
            entity.setInformacionUx( dto.getInformacionUx() );
        }
        if ( dto.getRespuesta() != null ) {
            entity.setRespuesta( dto.getRespuesta() );
        }
        if ( dto.getAtencion() != null ) {
            entity.setAtencion( dto.getAtencion() );
        }
        if ( dto.getEstado() != null ) {
            entity.setEstado( dto.getEstado() );
        }
        if ( dto.getCreadoEn() != null ) {
            entity.setCreadoEn( dto.getCreadoEn() );
        }
        if ( dto.getCreadoPor() != null ) {
            entity.setCreadoPor( Long.parseLong( dto.getCreadoPor() ) );
        }
    }
}
