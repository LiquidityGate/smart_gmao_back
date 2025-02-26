package com.gmao.gmao_backend.service;

import com.gmao.gmao_backend.dto.Configuracion.ConfiguracionActividadGestionDTO;
import com.gmao.gmao_backend.dto.Configuracion.ConfiguracionCargoDTO;
import com.gmao.gmao_backend.dto.Configuracion.ConfiguracionTipoAsignacionDTO;
import com.gmao.gmao_backend.dto.Configuracion.ConfiguracionTurnoDTO;
import com.gmao.gmao_backend.mapper.ConfiguracionMapper;
import com.gmao.gmao_backend.model.ActividadGestion;
import com.gmao.gmao_backend.model.Cargo;
import com.gmao.gmao_backend.model.TipoAsignacion;
import com.gmao.gmao_backend.model.Turno;
import com.gmao.gmao_backend.repository.TipoAsignacionRepository;
import com.gmao.gmao_backend.repository.TurnoRepository;
import com.gmao.gmao_backend.repository.ActividadGestionRepository;
import com.gmao.gmao_backend.repository.CargoRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Path;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ConfiguracionService {

    private final CargoRepository cargoRepository;
    private final TurnoRepository turnoRepository;
    private final ActividadGestionRepository actividadGestionRepository;
    private final TipoAsignacionRepository tipoAsignacionRepository;
    private final ConfiguracionMapper configuracionMapper;

    public ConfiguracionService(CargoRepository cargoRepository, TurnoRepository turnoRepository,
            ActividadGestionRepository actividadGestionRepository, TipoAsignacionRepository tipoAsignacionRepository,
            ConfiguracionMapper configuracionMapper) {
        this.cargoRepository = cargoRepository;
        this.turnoRepository = turnoRepository;
        this.actividadGestionRepository = actividadGestionRepository;
        this.tipoAsignacionRepository = tipoAsignacionRepository;
        this.configuracionMapper = configuracionMapper;
    }

    // Método para validar filtros de tipo String
    private void validateNullFilters(List<Predicate> predicates, CriteriaBuilder criteriaBuilder, Path<String> field,
            String value) {
        if (value != null && !value.trim().isEmpty() && !value.equals("null")) {
            predicates.add(criteriaBuilder.like(field, "%" + value + "%"));
        }
    }

    // Cargo
    public Page<ConfiguracionCargoDTO> findAllCargo(int page, int size, String sortField, String sortDirection,
            ConfiguracionCargoDTO filterDTO) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortField));

        Specification<Cargo> spec = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            validateNullFilters(predicates, criteriaBuilder, root.get("nombre"), filterDTO.getNombre());
            predicates.add(criteriaBuilder.notEqual(root.get("estadoEliminado"), true));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        Page<Cargo> dtoPage = cargoRepository.findAll(spec, pageable);
        return dtoPage.map(configuracionMapper::toDtoCargo);
    }

    public ConfiguracionCargoDTO saveCargo(ConfiguracionCargoDTO dto) {
        Cargo entidad = configuracionMapper.toEntityCargo(dto);
        System.out.println("Estado");
        System.out.println(entidad.getEstado());
        System.out.println("Estado Eliminado");
        System.out.println(entidad.getEstadoEliminado());
        Cargo savedEntidad = cargoRepository.save(entidad);

        ConfiguracionCargoDTO savedDTO = configuracionMapper.toDtoCargo(savedEntidad);
        return savedDTO;
    }

    public Map<String, Object> updateByIdCargo(Long id, ConfiguracionCargoDTO dto) {
        Cargo existingEntity = cargoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No encontrado"));
        ConfiguracionCargoDTO existingDTO = configuracionMapper
                .toDtoCargo(existingEntity);

        // Utiliza MapStruct para actualizar solo los valores no nulos
        configuracionMapper.updateFromDtoCargo(dto, existingEntity);

        Map<String, Object> result = new HashMap<>();
        result.put("updatedDTO", dto);
        result.put("existingDTO", existingDTO);

        return result;
    }

    // ------------------------------

    // Turno
    public Page<ConfiguracionTurnoDTO> findAllTurno(int page, int size, String sortField, String sortDirection,
            ConfiguracionTurnoDTO filterDTO) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortField));

        Specification<Turno> spec = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            validateNullFilters(predicates, criteriaBuilder, root.get("nombre"), filterDTO.getNombre());
            predicates.add(criteriaBuilder.notEqual(root.get("estadoEliminado"), true));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        Page<Turno> dtoPage = turnoRepository.findAll(spec, pageable);
        return dtoPage.map(configuracionMapper::toDtoTurno);
    }

    public ConfiguracionTurnoDTO saveTurno(ConfiguracionTurnoDTO dto) {
        Turno entidad = configuracionMapper.toEntityTurno(dto);
        System.out.println("Estado");
        System.out.println(entidad.getEstado());
        System.out.println("Estado Eliminado");
        System.out.println(entidad.getEstadoEliminado());
        Turno savedEntidad = turnoRepository.save(entidad);

        ConfiguracionTurnoDTO savedDTO = configuracionMapper.toDtoTurno(savedEntidad);
        return savedDTO;
    }

    public Map<String, Object> updateByIdTurno(Long id, ConfiguracionTurnoDTO dto) {
        Turno existingEntity = turnoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No encontrado"));
        ConfiguracionTurnoDTO existingDTO = configuracionMapper
                .toDtoTurno(existingEntity);

        // Utiliza MapStruct para actualizar solo los valores no nulos
        configuracionMapper.updateFromDtoTurno(dto, existingEntity);

        Map<String, Object> result = new HashMap<>();
        result.put("updatedDTO", dto);
        result.put("existingDTO", existingDTO);

        return result;
    }

    // Actividad Gestion
    public Page<ConfiguracionActividadGestionDTO> findAllActividadGestion(int page, int size, String sortField,
            String sortDirection,
            ConfiguracionActividadGestionDTO filterDTO) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortField));

        Specification<ActividadGestion> spec = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            validateNullFilters(predicates, criteriaBuilder, root.get("nombre"), filterDTO.getNombre());
            predicates.add(criteriaBuilder.notEqual(root.get("estadoEliminado"), true));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        Page<ActividadGestion> dtoPage = actividadGestionRepository.findAll(spec, pageable);
        return dtoPage.map(configuracionMapper::toDtoActividadGestion);
    }

    public ConfiguracionActividadGestionDTO saveActividadGestion(ConfiguracionActividadGestionDTO dto) {
        ActividadGestion entidad = configuracionMapper.toEntityActividadGestion(dto);
        System.out.println("Estado");
        System.out.println(entidad.getEstado());
        System.out.println("Estado Eliminado");
        System.out.println(entidad.getEstadoEliminado());
        ActividadGestion savedEntidad = actividadGestionRepository.save(entidad);

        ConfiguracionActividadGestionDTO savedDTO = configuracionMapper.toDtoActividadGestion(savedEntidad);
        return savedDTO;
    }

    public Map<String, Object> updateByIdActividadGestion(Long id, ConfiguracionActividadGestionDTO dto) {
        ActividadGestion existingEntity = actividadGestionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No encontrado"));
        ConfiguracionActividadGestionDTO existingDTO = configuracionMapper
                .toDtoActividadGestion(existingEntity);

        // Utiliza MapStruct para actualizar solo los valores no nulos
        configuracionMapper.updateFromDtoActividadGestion(dto, existingEntity);

        Map<String, Object> result = new HashMap<>();
        result.put("updatedDTO", dto);
        result.put("existingDTO", existingDTO);

        return result;
    }

    // Tipo Asignacion
    public Page<ConfiguracionTipoAsignacionDTO> findAllTipoAsignacion(int page, int size, String sortField,
            String sortDirection,
            ConfiguracionTipoAsignacionDTO filterDTO) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortField));

        Specification<TipoAsignacion> spec = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            validateNullFilters(predicates, criteriaBuilder, root.get("nombre"), filterDTO.getNombre());
            predicates.add(criteriaBuilder.notEqual(root.get("estadoEliminado"), true));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        Page<TipoAsignacion> dtoPage = tipoAsignacionRepository.findAll(spec, pageable);
        return dtoPage.map(configuracionMapper::toDtoTipoAsignacion);
    }

    public ConfiguracionTipoAsignacionDTO saveTipoAsignacion(ConfiguracionTipoAsignacionDTO dto) {
        TipoAsignacion entidad = configuracionMapper.toEntityTipoAsignacion(dto);
        System.out.println("Estado");
        System.out.println(entidad.getEstado());
        System.out.println("Estado Eliminado");
        System.out.println(entidad.getEstadoEliminado());
        TipoAsignacion savedEntidad = tipoAsignacionRepository.save(entidad);

        ConfiguracionTipoAsignacionDTO savedDTO = configuracionMapper.toDtoTipoAsignacion(savedEntidad);
        return savedDTO;
    }

    public Map<String, Object> updateByIdTipoAsignacion(Long id, ConfiguracionTipoAsignacionDTO dto) {
        TipoAsignacion existingEntity = tipoAsignacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No encontrado"));
        ConfiguracionTipoAsignacionDTO existingDTO = configuracionMapper
                .toDtoTipoAsignacion(existingEntity);

        // Utiliza MapStruct para actualizar solo los valores no nulos
        configuracionMapper.updateFromDtoTipoAsignacion(dto, existingEntity);

        Map<String, Object> result = new HashMap<>();
        result.put("updatedDTO", dto);
        result.put("existingDTO", existingDTO);

        return result;
    }

}