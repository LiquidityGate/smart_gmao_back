package com.gmao.gmao_backend.controller.Actividad;

import com.gmao.gmao_backend.model.Actividad.ActividadModel;
import com.gmao.gmao_backend.service.Actividad.ActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/actividad")
public class ActividadController {

    @Autowired
    private ActividadService actividadService;

    @GetMapping
    public List<ActividadModel> obtenerTodasActividades() {
        return actividadService.listarTodas();
    }
}
