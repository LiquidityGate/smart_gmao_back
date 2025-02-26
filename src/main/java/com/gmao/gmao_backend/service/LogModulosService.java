package com.gmao.gmao_backend.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gmao.gmao_backend.dto.LogModulosDTO;
import com.gmao.gmao_backend.dto.Auth.AuthAccesoMenuDTO;
import com.gmao.gmao_backend.mapper.LogModulosMapper;
import com.gmao.gmao_backend.model.LogModulos;
import com.gmao.gmao_backend.model.Menu;
import com.gmao.gmao_backend.model.Usuario;
import com.gmao.gmao_backend.repository.LogModulosRepository;
import com.gmao.gmao_backend.repository.MenuRepository;

import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;

@Service
public class LogModulosService {

        private final LogModulosMapper logModulosMapper;
        private final LogModulosRepository logModulosRepository;
        private final MenuRepository menuRepository;

        public LogModulosService(
                        LogModulosMapper logModulosMapper,
                        LogModulosRepository logModulosRepository, MenuRepository menuRepository) {
                this.logModulosMapper = logModulosMapper;
                this.logModulosRepository = logModulosRepository;
                this.menuRepository = menuRepository;
        }

        public void insertLogModulos(Usuario usuarioLog,
                        AuthAccesoMenuDTO dto) throws JsonProcessingException {

                // Convierte el DTO a entidad
                LogModulos entidad = new LogModulos();
                Optional<Menu> menuOpt = menuRepository.findMenusByURL(dto.getRuta());
                Long idMenu = menuOpt.map(Menu::getId).orElse(null);
                entidad.setRuta(dto.getRuta());
                entidad.setIdMenu(idMenu);
                entidad.setCreadoPor(usuarioLog.getId());
                entidad.setCreadoEn(new Timestamp(System.currentTimeMillis()));
                entidad.setIpAddress(dto.getIpAddress());
                entidad.setUserAgent(dto.getUserAgent());
                entidad.setAccesoMenu(dto.getAccesoMenu());
                entidad.setTokenJWT(dto.getTokenJWT());

                // Insertar
                logModulosRepository.save(entidad);

        }

}