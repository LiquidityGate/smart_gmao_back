package com.gmao.gmao_backend.service;

import com.gmao.gmao_backend.dto.MantenimientoPerfiles.MantenimientoPerfilesDTO;
import com.gmao.gmao_backend.dto.MantenimientoPerfiles.MantenimientoPerfilesMenusAccesosDTO;
import com.gmao.gmao_backend.dto.MantenimientoPerfiles.MantenimientoPerfilesMenusDTO;
import com.gmao.gmao_backend.mapper.MantenimientoPerfilesMapper;
import com.gmao.gmao_backend.mapper.UsuarioPerfilMapper;
import com.gmao.gmao_backend.model.AccesoXPerfil;
import com.gmao.gmao_backend.model.UsuarioPerfil;
import com.gmao.gmao_backend.repository.UsuarioPerfilRepository;
import com.gmao.gmao_backend.repository.UsuarioRepository;
import com.gmao.gmao_backend.repository.AccesoXPerfilRepository;
import com.gmao.gmao_backend.repository.MantenimientoPerfilesRepository;

import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class MantenimientoPerfilesService {

    private final MantenimientoPerfilesRepository mantenimientoPerfilesRepository;
    private final AccesoXPerfilRepository accesoXPerfilRepository;
    private final MantenimientoPerfilesMapper mantenimientoPerfilesMapper;

    public MantenimientoPerfilesService(UsuarioPerfilRepository usrPerfilRepository,
            UsuarioPerfilMapper usrPerfilMapper,
            UsuarioRepository usuarioRepository, MantenimientoPerfilesRepository mantenimientoPerfilesRepository,
            AccesoXPerfilRepository accesoXPerfilRepository, MantenimientoPerfilesMapper mantenimientoPerfilesMapper) {
        this.mantenimientoPerfilesRepository = mantenimientoPerfilesRepository;
        this.accesoXPerfilRepository = accesoXPerfilRepository;
        this.mantenimientoPerfilesMapper = mantenimientoPerfilesMapper;
    }

    public List<MantenimientoPerfilesDTO> findDatosPerfil(Long id_perfil) {
        List<MantenimientoPerfilesDTO> allMenusObj = mantenimientoPerfilesRepository.findDatosPerfil(id_perfil);

        return allMenusObj;
    }

    public List<MantenimientoPerfilesMenusDTO> findMenusByPerfil(Long id_perfil) {
        List<Object[]> allMenusObj = mantenimientoPerfilesRepository.findMenusByPerfil(id_perfil);
        List<MantenimientoPerfilesMenusDTO> allMenus = allMenusObj.stream()
                .map(record -> new MantenimientoPerfilesMenusDTO((Long) record[0], (String) record[1],
                        (Long) record[2], (Long) record[3],
                        (String) record[4], (Double) record[5], (String) record[6], (Boolean) record[7],
                        (Long) record[8], new ArrayList<>(), (Boolean) record[9], (Boolean) record[10],
                        (Boolean) record[11], (Boolean) record[12]))
                .collect(Collectors.toList());

        return allMenus;
    }
    /*
     * public List<MantenimientoPerfilesMenusDTO> findMenusByPerfil2(Long id_perfil)
     * {
     * List<Object[]> allMenusObj =
     * mantenimientoPerfilesRepository.findMenusByPerfil(id_perfil);
     * List<MantenimientoPerfilesMenusDTO> allMenus = allMenusObj.stream()
     * .map(record -> new MantenimientoPerfilesMenusDTO((Long) record[0], (String)
     * record[1],
     * (Long) record[2], (Long) record[3],
     * (String) record[4], (Double) record[5], (String) record[6], (Boolean)
     * record[7],
     * (Long) record[8], new ArrayList<>()))
     * .collect(Collectors.toList());
     * 
     * Map<Long, MantenimientoPerfilesMenusDTO> menuDTOMap = new HashMap<>();
     * 
     * // Primero agregamos todos los menús al mapa (incluso submenús)
     * for (MantenimientoPerfilesMenusDTO menu : allMenus) {
     * MantenimientoPerfilesMenusDTO dto = new
     * MantenimientoPerfilesMenusDTO(menu.getId(), menu.getNombre(),
     * menu.getMenuPadre(), menu.getSubMenuPadre(), menu.getUrl(),
     * menu.getOrden(), menu.getIcono(), menu.getEstado(), menu.getIdMenuAcceso(),
     * menu.getSubMenu());
     * 
     * // Agregamos todos los menús al mapa, incluso submenús
     * menuDTOMap.put(dto.getId(), dto);
     * }
     * 
     * // Ahora procesamos los menús para establecer la relación padre-hijo entre
     * menús
     * // y submenús
     * for (MantenimientoPerfilesMenusDTO menu : allMenus) {
     * MantenimientoPerfilesMenusDTO dto = menuDTOMap.get(menu.getId()); //
     * Obtenemos el DTO del menú actual
     * 
     * // Si el menú tiene un padre (no es un menú principal)
     * if (menu.getMenuPadre() != 0 && menu.getSubMenuPadre() == 0) {
     * // Buscamos el menú padre
     * MantenimientoPerfilesMenusDTO parentDto =
     * menuDTOMap.get(menu.getMenuPadre());
     * 
     * if (parentDto != null) {
     * // Si encontramos el menú padre, lo agregamos como submenú
     * parentDto.getSubMenu().add(dto);
     * }
     * }
     * 
     * // Ahora agregamos el submenú de segundo nivel si lo tiene (subMenuPadre)
     * if (menu.getSubMenuPadre() != 0) {
     * // Buscamos el submenú padre (de segundo nivel)
     * MantenimientoPerfilesMenusDTO subMenuPadreDto =
     * menuDTOMap.get(menu.getSubMenuPadre());
     * 
     * if (subMenuPadreDto != null) {
     * // Si encontramos el submenú padre, agregamos el menú actual como submenú de
     * // este
     * subMenuPadreDto.getSubMenu().add(dto);
     * }
     * }
     * }
     * 
     * // Devolvemos solo los menús principales (aquellos que no tienen `menuPadre
     * ==
     * // 0`)
     * return new ArrayList<>(menuDTOMap.values().stream()
     * .filter(dto -> dto.getMenuPadre() == 0) // Filtramos solo los menús
     * principales
     * .collect(Collectors.toList()));
     * }
     */

    // Crear un nuevo menú
    public MantenimientoPerfilesMenusAccesosDTO saveMenus(MantenimientoPerfilesMenusAccesosDTO dto) {
        // Convierte el DTO a entidad
        AccesoXPerfil entidad = mantenimientoPerfilesMapper.toEntityMenus(dto);

        AccesoXPerfil savedEntidad = accesoXPerfilRepository.save(entidad);

        MantenimientoPerfilesMenusAccesosDTO savedDTO = mantenimientoPerfilesMapper.toDtoMenus(savedEntidad);
        return savedDTO;
    }

    // Crear un nuevo menú
    public MantenimientoPerfilesMenusAccesosDTO findByIdMenu(MantenimientoPerfilesMenusAccesosDTO dto) {
        // Convierte el DTO a entidad
        AccesoXPerfil entidad = mantenimientoPerfilesMapper.toEntityMenus(dto);

        AccesoXPerfil savedEntidad = accesoXPerfilRepository.save(entidad);

        MantenimientoPerfilesMenusAccesosDTO savedDTO = mantenimientoPerfilesMapper.toDtoMenus(savedEntidad);
        return savedDTO;
    }

    // Obtener una orden de trabajo por ID y convertirla a DTO
    public Optional<AccesoXPerfil> findByIdMenu(Long id) {
        return accesoXPerfilRepository.findById(id);
    }

    // Eliminar una orden de trabajo por ID
    public void deleteByIdMenu(Long id) {
        accesoXPerfilRepository.deleteById(id);
    }

    public Map<String, Object> updateByIdMenu(Long id, MantenimientoPerfilesMenusAccesosDTO dto) {
        AccesoXPerfil existingAccesoXPerfil = accesoXPerfilRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Acceso por perfil no encontrado"));
        MantenimientoPerfilesMenusAccesosDTO existingDTO = mantenimientoPerfilesMapper
                .toDtoMenus(existingAccesoXPerfil);

        // Utiliza MapStruct para actualizar solo los valores no nulos
        mantenimientoPerfilesMapper.updateFromDtoAccesoXPerfil(dto, existingAccesoXPerfil);

        Map<String, Object> result = new HashMap<>();
        result.put("updatedDTO", dto);
        result.put("existingDTO", existingDTO);

        return result;
    }

    public Map<String, Object> updateById(Long id, MantenimientoPerfilesDTO dto) {
        UsuarioPerfil existingEntity = mantenimientoPerfilesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No encontrado"));
        MantenimientoPerfilesDTO existingDTO = mantenimientoPerfilesMapper
                .toDtoUsuarioPerfil(existingEntity);

        // Utiliza MapStruct para actualizar solo los valores no nulos
        mantenimientoPerfilesMapper.updateFromDtoMantenimientoPerfilesDTO(dto, existingEntity);

        Map<String, Object> result = new HashMap<>();
        result.put("updatedDTO", dto);
        result.put("existingDTO", existingDTO);

        return result;
    }
}