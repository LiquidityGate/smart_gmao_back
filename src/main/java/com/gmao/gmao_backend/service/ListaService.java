package com.gmao.gmao_backend.service;

import com.gmao.gmao_backend.dto.ListaDTO;
import com.gmao.gmao_backend.mapper.ListaMapper;
import com.gmao.gmao_backend.repository.EmpresaRepository;
import com.gmao.gmao_backend.repository.Usu_cargoRepository;
import com.gmao.gmao_backend.repository.Usu_turnoRepository;
import com.gmao.gmao_backend.repository.UsuarioSubtipoRepository;
import com.gmao.gmao_backend.repository.UsuarioTipoIdentidadRepository;
import com.gmao.gmao_backend.repository.Usu_cargoRepository;
import com.gmao.gmao_backend.repository.Usu_turnoRepository;

import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.List;

@Service
public class ListaService {

    private final ListaMapper listaMapper;
    private final UsuarioSubtipoRepository usuarioSubtipoRepository;
    private final UsuarioTipoIdentidadRepository usuarioTipoIdentidadRepository;
    private final EmpresaRepository empresaRepository;
    private final Usu_cargoRepository usu_cargoRepository;
    private final Usu_turnoRepository usu_turnoRepository;

    public ListaService(ListaMapper listaMapper, UsuarioSubtipoRepository usuarioSubtipoRepository,
            UsuarioTipoIdentidadRepository usuarioTipoIdentidadRepository,
            EmpresaRepository empresaRepository, Usu_cargoRepository usu_cargoRepository,
            Usu_turnoRepository usu_turnoRepository) {
        this.listaMapper = listaMapper;
        this.usuarioSubtipoRepository = usuarioSubtipoRepository;
        this.usuarioTipoIdentidadRepository = usuarioTipoIdentidadRepository;
        this.empresaRepository = empresaRepository;
        this.usu_cargoRepository = usu_cargoRepository;
        this.usu_turnoRepository = usu_turnoRepository;
    }

    public List<ListaDTO> findAllForSelectSubtipo() {
        return usuarioSubtipoRepository.findAll().stream()
                .map(listaMapper::toDtoSubtipo)
                .collect(Collectors.toList());
    }

    public List<ListaDTO> findAllForSelectEmpresa() {
        return empresaRepository.findAll().stream()
                .map(listaMapper::toDtoEmpresa)
                .collect(Collectors.toList());
    }

    public List<ListaDTO> findAllForSelectTipoIdentidad() {
        return usuarioTipoIdentidadRepository.findAll().stream()
                .map(listaMapper::toDtoTipoIdentidad)
                .collect(Collectors.toList());
    }

    public List<ListaDTO> findAllForSelectCargo() {
        return usu_cargoRepository.findAll().stream()
                .map(listaMapper::toDtoCargo)
                .collect(Collectors.toList());
    }

    public List<ListaDTO> findAllForSelectTurno() {
        return usu_turnoRepository.findAll().stream()
                .map(listaMapper::toDtoTurno)
                .collect(Collectors.toList());
    }
}