package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.Usu_feedbackDTO;
import com.gmao.gmao_backend.model.Usu_feedback;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-25T14:12:09-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class Usu_feedbackMapperImpl implements Usu_feedbackMapper {

    @Override
    public Usu_feedbackDTO toDto(Usu_feedback usu_feedback) {
        if ( usu_feedback == null ) {
            return null;
        }

        Usu_feedbackDTO usu_feedbackDTO = new Usu_feedbackDTO();

        usu_feedbackDTO.setId( usu_feedback.getId() );
        usu_feedbackDTO.setId_usuario( usu_feedback.getId_usuario() );
        usu_feedbackDTO.setId_menu( usu_feedback.getId_menu() );
        usu_feedbackDTO.setArchivo_img( usu_feedback.getArchivo_img() );
        usu_feedbackDTO.setSatisfaccion_ux( usu_feedback.getSatisfaccion_ux() );
        usu_feedbackDTO.setNavegacion_ux( usu_feedback.getNavegacion_ux() );
        usu_feedbackDTO.setVisual_ux( usu_feedback.getVisual_ux() );
        usu_feedbackDTO.setInformacion_ux( usu_feedback.getInformacion_ux() );
        usu_feedbackDTO.setDescripcion( usu_feedback.getDescripcion() );
        usu_feedbackDTO.setFecha_crea( usu_feedback.getFecha_crea() );
        usu_feedbackDTO.setRespuesta( usu_feedback.getRespuesta() );
        usu_feedbackDTO.setFecha_rpt( usu_feedback.getFecha_rpt() );
        usu_feedbackDTO.setId_usu_rpt( usu_feedback.getId_usu_rpt() );
        usu_feedbackDTO.setEstado_aten( usu_feedback.getEstado_aten() );
        usu_feedbackDTO.setFecha_cierre( usu_feedback.getFecha_cierre() );
        usu_feedbackDTO.setEstado( usu_feedback.getEstado() );

        return usu_feedbackDTO;
    }

    @Override
    public Usu_feedback toEntity(Usu_feedbackDTO usu_feedbackDTO) {
        if ( usu_feedbackDTO == null ) {
            return null;
        }

        Usu_feedback usu_feedback = new Usu_feedback();

        usu_feedback.setId( usu_feedbackDTO.getId() );
        usu_feedback.setId_usuario( usu_feedbackDTO.getId_usuario() );
        usu_feedback.setId_menu( usu_feedbackDTO.getId_menu() );
        usu_feedback.setArchivo_img( usu_feedbackDTO.getArchivo_img() );
        usu_feedback.setSatisfaccion_ux( usu_feedbackDTO.getSatisfaccion_ux() );
        usu_feedback.setNavegacion_ux( usu_feedbackDTO.getNavegacion_ux() );
        usu_feedback.setVisual_ux( usu_feedbackDTO.getVisual_ux() );
        usu_feedback.setInformacion_ux( usu_feedbackDTO.getInformacion_ux() );
        usu_feedback.setDescripcion( usu_feedbackDTO.getDescripcion() );
        usu_feedback.setFecha_crea( usu_feedbackDTO.getFecha_crea() );
        usu_feedback.setRespuesta( usu_feedbackDTO.getRespuesta() );
        usu_feedback.setFecha_rpt( usu_feedbackDTO.getFecha_rpt() );
        usu_feedback.setId_usu_rpt( usu_feedbackDTO.getId_usu_rpt() );
        usu_feedback.setEstado_aten( usu_feedbackDTO.getEstado_aten() );
        usu_feedback.setFecha_cierre( usu_feedbackDTO.getFecha_cierre() );
        usu_feedback.setEstado( usu_feedbackDTO.getEstado() );

        return usu_feedback;
    }

    @Override
    public void updateFromDto(Usu_feedbackDTO dto, Usu_feedback entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getId_usuario() != null ) {
            entity.setId_usuario( dto.getId_usuario() );
        }
        if ( dto.getId_menu() != null ) {
            entity.setId_menu( dto.getId_menu() );
        }
        if ( dto.getArchivo_img() != null ) {
            entity.setArchivo_img( dto.getArchivo_img() );
        }
        if ( dto.getSatisfaccion_ux() != null ) {
            entity.setSatisfaccion_ux( dto.getSatisfaccion_ux() );
        }
        if ( dto.getNavegacion_ux() != null ) {
            entity.setNavegacion_ux( dto.getNavegacion_ux() );
        }
        if ( dto.getVisual_ux() != null ) {
            entity.setVisual_ux( dto.getVisual_ux() );
        }
        if ( dto.getInformacion_ux() != null ) {
            entity.setInformacion_ux( dto.getInformacion_ux() );
        }
        if ( dto.getDescripcion() != null ) {
            entity.setDescripcion( dto.getDescripcion() );
        }
        if ( dto.getFecha_crea() != null ) {
            entity.setFecha_crea( dto.getFecha_crea() );
        }
        if ( dto.getRespuesta() != null ) {
            entity.setRespuesta( dto.getRespuesta() );
        }
        if ( dto.getFecha_rpt() != null ) {
            entity.setFecha_rpt( dto.getFecha_rpt() );
        }
        if ( dto.getId_usu_rpt() != null ) {
            entity.setId_usu_rpt( dto.getId_usu_rpt() );
        }
        if ( dto.getEstado_aten() != null ) {
            entity.setEstado_aten( dto.getEstado_aten() );
        }
        if ( dto.getFecha_cierre() != null ) {
            entity.setFecha_cierre( dto.getFecha_cierre() );
        }
        if ( dto.getEstado() != null ) {
            entity.setEstado( dto.getEstado() );
        }
    }
}
