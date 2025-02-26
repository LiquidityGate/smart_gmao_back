package com.gmao.gmao_backend.service.Actividad;

import com.gmao.gmao_backend.model.Actividad.ActividadModel;
import com.gmao.gmao_backend.repository.Actividad.ActividadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActividadService {
    @Autowired
    private ActividadRepository actividadRepository;

    public List<ActividadModel> listarTodas() {
        return actividadRepository.findAll();
    }
}
