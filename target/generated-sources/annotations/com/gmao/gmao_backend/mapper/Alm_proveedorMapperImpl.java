package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.Alm_proveedorDTO;
import com.gmao.gmao_backend.model.Alm_proveedor;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-25T14:12:10-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class Alm_proveedorMapperImpl implements Alm_proveedorMapper {

    @Override
    public Alm_proveedorDTO toDto(Alm_proveedor alm_proveedor) {
        if ( alm_proveedor == null ) {
            return null;
        }

        Alm_proveedorDTO alm_proveedorDTO = new Alm_proveedorDTO();

        alm_proveedorDTO.setId( alm_proveedor.getId() );
        alm_proveedorDTO.setRuc( alm_proveedor.getRuc() );
        alm_proveedorDTO.setRazon_social( alm_proveedor.getRazon_social() );
        alm_proveedorDTO.setNom_comercial( alm_proveedor.getNom_comercial() );
        alm_proveedorDTO.setDireccion( alm_proveedor.getDireccion() );
        alm_proveedorDTO.setCod_postal( alm_proveedor.getCod_postal() );
        alm_proveedorDTO.setCiudad( alm_proveedor.getCiudad() );
        alm_proveedorDTO.setProvincia( alm_proveedor.getProvincia() );
        alm_proveedorDTO.setPais( alm_proveedor.getPais() );
        alm_proveedorDTO.setTelefono( alm_proveedor.getTelefono() );
        alm_proveedorDTO.setEmail( alm_proveedor.getEmail() );
        alm_proveedorDTO.setPagina_web( alm_proveedor.getPagina_web() );
        alm_proveedorDTO.setPer_contacto( alm_proveedor.getPer_contacto() );
        alm_proveedorDTO.setEmail_contacto( alm_proveedor.getEmail_contacto() );
        alm_proveedorDTO.setTlf_contacto( alm_proveedor.getTlf_contacto() );
        alm_proveedorDTO.setEstado( alm_proveedor.getEstado() );

        return alm_proveedorDTO;
    }

    @Override
    public Alm_proveedor toEntity(Alm_proveedorDTO alm_proveedorDTO) {
        if ( alm_proveedorDTO == null ) {
            return null;
        }

        Alm_proveedor alm_proveedor = new Alm_proveedor();

        alm_proveedor.setId( alm_proveedorDTO.getId() );
        alm_proveedor.setRuc( alm_proveedorDTO.getRuc() );
        alm_proveedor.setRazon_social( alm_proveedorDTO.getRazon_social() );
        alm_proveedor.setNom_comercial( alm_proveedorDTO.getNom_comercial() );
        alm_proveedor.setDireccion( alm_proveedorDTO.getDireccion() );
        alm_proveedor.setCod_postal( alm_proveedorDTO.getCod_postal() );
        alm_proveedor.setCiudad( alm_proveedorDTO.getCiudad() );
        alm_proveedor.setProvincia( alm_proveedorDTO.getProvincia() );
        alm_proveedor.setPais( alm_proveedorDTO.getPais() );
        alm_proveedor.setTelefono( alm_proveedorDTO.getTelefono() );
        alm_proveedor.setEmail( alm_proveedorDTO.getEmail() );
        alm_proveedor.setPagina_web( alm_proveedorDTO.getPagina_web() );
        alm_proveedor.setPer_contacto( alm_proveedorDTO.getPer_contacto() );
        alm_proveedor.setEmail_contacto( alm_proveedorDTO.getEmail_contacto() );
        alm_proveedor.setTlf_contacto( alm_proveedorDTO.getTlf_contacto() );
        alm_proveedor.setEstado( alm_proveedorDTO.getEstado() );

        return alm_proveedor;
    }

    @Override
    public void updateFromDto(Alm_proveedorDTO dto, Alm_proveedor entity) {
        if ( dto == null ) {
            return;
        }

        entity.setId( dto.getId() );
        if ( dto.getRuc() != null ) {
            entity.setRuc( dto.getRuc() );
        }
        if ( dto.getRazon_social() != null ) {
            entity.setRazon_social( dto.getRazon_social() );
        }
        if ( dto.getNom_comercial() != null ) {
            entity.setNom_comercial( dto.getNom_comercial() );
        }
        if ( dto.getDireccion() != null ) {
            entity.setDireccion( dto.getDireccion() );
        }
        if ( dto.getCod_postal() != null ) {
            entity.setCod_postal( dto.getCod_postal() );
        }
        if ( dto.getCiudad() != null ) {
            entity.setCiudad( dto.getCiudad() );
        }
        if ( dto.getProvincia() != null ) {
            entity.setProvincia( dto.getProvincia() );
        }
        if ( dto.getPais() != null ) {
            entity.setPais( dto.getPais() );
        }
        if ( dto.getTelefono() != null ) {
            entity.setTelefono( dto.getTelefono() );
        }
        if ( dto.getEmail() != null ) {
            entity.setEmail( dto.getEmail() );
        }
        if ( dto.getPagina_web() != null ) {
            entity.setPagina_web( dto.getPagina_web() );
        }
        if ( dto.getPer_contacto() != null ) {
            entity.setPer_contacto( dto.getPer_contacto() );
        }
        if ( dto.getEmail_contacto() != null ) {
            entity.setEmail_contacto( dto.getEmail_contacto() );
        }
        if ( dto.getTlf_contacto() != null ) {
            entity.setTlf_contacto( dto.getTlf_contacto() );
        }
        if ( dto.getEstado() != null ) {
            entity.setEstado( dto.getEstado() );
        }
    }
}
