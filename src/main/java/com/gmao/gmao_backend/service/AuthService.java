package com.gmao.gmao_backend.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gmao.gmao_backend.dto.Auth.AuthAccesoMenuDTO;
import com.gmao.gmao_backend.dto.Auth.AuthPermisosMenuDTO;
import com.gmao.gmao_backend.dto.Auth.AuthSesionesDTO;
import com.gmao.gmao_backend.model.LogModulos;
import com.gmao.gmao_backend.model.LogSesiones;
import com.gmao.gmao_backend.model.Menu;
import com.gmao.gmao_backend.model.Usuario;
import com.gmao.gmao_backend.repository.AuthRepository;
import com.gmao.gmao_backend.repository.LogModulosRepository;
import com.gmao.gmao_backend.repository.LogSesionesRepository;
import com.gmao.gmao_backend.repository.MenuRepository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthRepository authRepository;
    private final LogModulosRepository logModulosRepository;
    private final MenuRepository menuRepository;
    private final LogSesionesRepository logSesionesRepository;

    public AuthService(AuthRepository authRepository, LogModulosRepository logModulosRepository,
            MenuRepository menuRepository, LogSesionesRepository logSesionesRepository) {
        this.authRepository = authRepository;
        this.logModulosRepository = logModulosRepository;
        this.menuRepository = menuRepository;
        this.logSesionesRepository = logSesionesRepository;
    }

    public Boolean getAccesoMenu(String ruta, Usuario usuarioP) {
        List<Object[]> result = authRepository.findAccesoMenu(ruta, usuarioP.getPerfil().getId());

        if (result == null || result.isEmpty()) {
            return false; // Devuelve false si no hay filas
        }

        Object firstColumnValue = result.get(0)[0];

        if (firstColumnValue instanceof Boolean && !(Boolean) firstColumnValue) {
            return false;
        }

        return true;
    }

    public List<AuthPermisosMenuDTO> getPermisosMenu(String ruta, Long id_perfil) {
        List<Object[]> result = authRepository.findPermisosMenu(ruta, id_perfil);

        List<AuthPermisosMenuDTO> authPermisosMenuDTO = result.stream()
                .map(record -> new AuthPermisosMenuDTO((String) record[0], (Long) record[1],
                        (Boolean) record[2], (Boolean) record[3],
                        (Boolean) record[4], (Boolean) record[5], (Boolean) record[6]))
                .collect(Collectors.toList());

        return authPermisosMenuDTO;
    }

    public Long insertLogSesiones(Usuario usuarioLog,
            AuthSesionesDTO dto) throws JsonProcessingException {

        // Convierte el DTO a entidad
        LogSesiones entidad = new LogSesiones();
        entidad.setIdUsuario(usuarioLog.getId());
        entidad.setFechaInicio(new Timestamp(System.currentTimeMillis()));
        entidad.setIpAddress(dto.getIpAddress());
        entidad.setUserAgent(dto.getUserAgent());
        entidad.setAcceso(dto.getAcceso());
        entidad.setTokenJWT(dto.getTokenJWT());

        // Insertar
        logSesionesRepository.save(entidad);

        return entidad.getId();

    }

    public void insertLogModulos(Usuario usuarioLog,
            AuthAccesoMenuDTO dto) throws JsonProcessingException {

        // Convierte el DTO a entidad
        LogModulos entidad = new LogModulos();
        Optional<Menu> menuOpt = menuRepository.findMenusByURL(dto.getRuta());
        Long idMenu = menuOpt.map(Menu::getId).orElse(null);
        entidad.setRuta(dto.getRuta());
        entidad.setIdSesion(dto.getIdSesion());
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