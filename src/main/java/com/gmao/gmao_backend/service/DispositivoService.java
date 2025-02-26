package com.gmao.gmao_backend.service;

import com.gmao.gmao_backend.model.Dispositivo;
import com.gmao.gmao_backend.repository.DispositivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DispositivoService {

    @Autowired
    private DispositivoRepository dispositivoRepository;

    public Page<Dispositivo> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return dispositivoRepository.findAll(pageable);
    }

    public Dispositivo obtenerPorId(int id) {
        return dispositivoRepository.findById(id).orElse(null);
    }

    public Dispositivo guardarDispositivo(Dispositivo dispositivo) {
        return dispositivoRepository.save(dispositivo);
    }

    public void eliminarDispositivo(int id) {
        dispositivoRepository.deleteById(id);
    }
}