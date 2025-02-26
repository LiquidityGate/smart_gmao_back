package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.MenuDTO;
import com.gmao.gmao_backend.model.Menu;

import org.springframework.stereotype.Component;

@Component
public class MenuMapper {

    // Método para convertir de Entidad a DTO
    public MenuDTO toDto(Menu menu) {
        if (menu == null) {
            return null;
        }

        MenuDTO dto = new MenuDTO();
        dto.setId(menu.getId());
        dto.setNombre(menu.getNombre());
        dto.setOrden(menu.getOrden());
        dto.setUrl(menu.getUrl());
        dto.setIcono(menu.getIcono());
        dto.setMenuPadre(menu.getMenuPadre());
        dto.setIngles(menu.getIngles());
        return dto;
    }

    // Método para convertir de DTO a Entidad
    public Menu toEntity(MenuDTO menuDTO) {
        if (menuDTO == null) {
            return null;
        }

        Menu menu = new Menu();
        menu.setId(menuDTO.getId());
        menu.setNombre(menuDTO.getNombre());
        menu.setOrden(menuDTO.getOrden());
        menu.setIcono(menuDTO.getIcono());
        menu.setMenuPadre(menuDTO.getMenuPadre());
        menu.setIngles(menuDTO.getIngles());

        return menu;
    }
}