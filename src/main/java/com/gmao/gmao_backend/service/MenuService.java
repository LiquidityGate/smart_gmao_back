package com.gmao.gmao_backend.service;

import com.gmao.gmao_backend.dto.MenuDTO;
import com.gmao.gmao_backend.model.Menu;
import com.gmao.gmao_backend.repository.MenuRepository;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class MenuService {

    @Autowired
    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    // Método para obtener solo los campos necesarios para el select box
    public List<MenuDTO> findAllMenusAcceso(Long id_usuario, Long id_perfil) {
        System.out.println("El id perfil es " + id_perfil);
        List<Menu> allMenus = menuRepository.findMenusByPerfilAndUsuario(id_perfil, id_usuario);
        Map<Long, MenuDTO> menuDTOMap = new HashMap<>();

        // Primero agregamos todos los menús al mapa (incluso submenús)
        for (Menu menu : allMenus) {
            MenuDTO dto = new MenuDTO(menu.getId(), menu.getNombre(), menu.getUrl(), menu.getOrden(), menu.getEstado(),
                    menu.getIcono(), menu.getMenuPadre(), menu.getSubMenuPadre(), new ArrayList<>(),
                    menu.getIngles(), menu.getAleman(), menu.getItaliano(), menu.getRuso());

            // Agregamos todos los menús al mapa, incluso submenús
            menuDTOMap.put(dto.getId(), dto);
        }

        // Ahora procesamos los menús para establecer la relación padre-hijo entre menús
        // y submenús
        for (Menu menu : allMenus) {
            MenuDTO dto = menuDTOMap.get(menu.getId()); // Obtenemos el DTO del menú actual

            // Si el menú tiene un padre (no es un menú principal)
            if (menu.getMenuPadre() != 0 && menu.getSubMenuPadre() == 0) {
                // Buscamos el menú padre
                MenuDTO parentDto = menuDTOMap.get(menu.getMenuPadre());

                if (parentDto != null) {
                    // Si encontramos el menú padre, lo agregamos como submenú
                    parentDto.getSubMenu().add(dto);
                }
            }

            // Ahora agregamos el submenú de segundo nivel si lo tiene (subMenuPadre)
            if (menu.getSubMenuPadre() != 0) {
                // Buscamos el submenú padre (de segundo nivel)
                MenuDTO subMenuPadreDto = menuDTOMap.get(menu.getSubMenuPadre());

                if (subMenuPadreDto != null) {
                    // Si encontramos el submenú padre, agregamos el menú actual como submenú de
                    // este
                    subMenuPadreDto.getSubMenu().add(dto);
                }
            }
        }

        // Devolvemos solo los menús principales (aquellos que no tienen `menuPadre ==
        // 0`)
        return new ArrayList<>(menuDTOMap.values().stream()
                .filter(dto -> dto.getMenuPadre() == 0) // Filtramos solo los menús principales
                .collect(Collectors.toList()));
    }

}