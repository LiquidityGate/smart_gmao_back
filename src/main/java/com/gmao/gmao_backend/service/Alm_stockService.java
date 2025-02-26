package com.gmao.gmao_backend.service;

import com.gmao.gmao_backend.dto.Alm_stockDTO;
import com.gmao.gmao_backend.mapper.Alm_stockMapper;
import com.gmao.gmao_backend.model.Alm_stock;
import com.gmao.gmao_backend.repository.Alm_stockRepository;
import com.gmao.gmao_backend.repository.AdministracionUsuariosRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Path;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

@Service
public class Alm_stockService {
    
    private final Alm_stockRepository alm_stockRepository;
    private final Alm_stockMapper alm_stockMapper;

    public Alm_stockService(Alm_stockRepository alm_stockRepository, AdministracionUsuariosRepository usuarioRepository, Alm_stockMapper alm_stockMapper) {
        this.alm_stockRepository = alm_stockRepository;
        this.alm_stockMapper = alm_stockMapper;
    }

    private void validateNullFilters(List<Predicate> predicates, CriteriaBuilder criteriaBuilder, Path<String> field, String value) {
        if (value != null && !value.trim().isEmpty() && !value.equals("null")) {
            predicates.add(criteriaBuilder.like(field, "%" + value + "%"));
        }
    }

    private void validateIdFilters(List<Predicate> predicates, CriteriaBuilder criteriaBuilder, Path<Long> field, Long value) {
        if (value != null ) {
            predicates.add(criteriaBuilder.equal(field, value));
        }
    }

    public Page<Alm_stockDTO> findAll(int page, int size, String sortField, String sortDirection, Alm_stockDTO filterDTO) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortField));

        Page<Alm_stock> alm_stocksPage = alm_stockRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            validateNullFilters(predicates, criteriaBuilder, root.get("articulo"), filterDTO.getArticulo());

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);

        return alm_stocksPage.map(alm_stockMapper::toDto);
    }

    public Optional<Alm_stockDTO> findById(Long id) {
        return alm_stockRepository.findById(id)
                                     .map(alm_stockMapper::toDto);
    }

    public Alm_stockDTO save(Alm_stockDTO alm_stockDTO) {
        Alm_stock alm_stock = alm_stockMapper.toEntity(alm_stockDTO);
        Alm_stock savedAlm_stock = alm_stockRepository.save(alm_stock);
        return alm_stockMapper.toDto(savedAlm_stock);
    }

    public Alm_stockDTO update(Long id, Alm_stockDTO alm_stockDTO) {
        Alm_stock existingAlm_stock = alm_stockRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alm_stock no encontrada"));

        alm_stockMapper.updateFromDto(alm_stockDTO, existingAlm_stock);

        Alm_stock updatedAlm_stock = alm_stockRepository.save(existingAlm_stock);
        return alm_stockMapper.toDto(updatedAlm_stock);
    }

    public void deleteById(Long id) {
        alm_stockRepository.deleteById(id);
    }
}