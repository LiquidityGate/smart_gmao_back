package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.Usu_log_detallesDTO;
import com.gmao.gmao_backend.model.Usu_log_detalles;
import org.springframework.stereotype.Component;

@Component
public class Usu_log_detallesMapper {
    
    public Usu_log_detallesDTO toDTO(Usu_log_detalles entity) {
        if (entity == null) {
            return null;
        }

        Usu_log_detallesDTO dto = new Usu_log_detallesDTO();
        dto.setCreado_por(entity.getCreado_por());
        dto.setRuta(entity.getRuta());
        dto.setCreado_en(entity.getCreado_en());
        dto.setIp_address(entity.getIp_address());
        dto.setUser_agent(entity.getUser_agent());
        return dto;
    }

    public Usu_log_detalles toEntity(Usu_log_detallesDTO dto) {
        if (dto == null) {
            return null;
        }

        Usu_log_detalles entity = new Usu_log_detalles();
        entity.setCreado_por(dto.getCreado_por());
        entity.setRuta(dto.getRuta());
        entity.setCreado_en(dto.getCreado_en());
        entity.setIp_address(dto.getIp_address());
        entity.setUser_agent(dto.getUser_agent());
        return entity;
    }
}
