package com.gmao.gmao_backend.mapper;

import com.gmao.gmao_backend.dto.Alm_partidaDTO;
import com.gmao.gmao_backend.model.Alm_partida;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-25T14:12:09-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class Alm_partidaMapperImpl implements Alm_partidaMapper {

    @Override
    public Alm_partidaDTO toDto(Alm_partida alm_partida) {
        if ( alm_partida == null ) {
            return null;
        }

        Long id = null;
        String descripcion = null;
        String ano = null;
        String cod_item = null;
        String item = null;
        String n_cuenta = null;
        String tipo_partida = null;
        String capitulo = null;
        String tipo_capitulo = null;
        String importe = null;
        String partida_pp = null;
        String estado = null;

        id = alm_partida.getId();
        descripcion = alm_partida.getDescripcion();
        ano = alm_partida.getAno();
        cod_item = alm_partida.getCod_item();
        item = alm_partida.getItem();
        n_cuenta = alm_partida.getN_cuenta();
        tipo_partida = alm_partida.getTipo_partida();
        capitulo = alm_partida.getCapitulo();
        tipo_capitulo = alm_partida.getTipo_capitulo();
        importe = alm_partida.getImporte();
        partida_pp = alm_partida.getPartida_pp();
        estado = alm_partida.getEstado();

        Alm_partidaDTO alm_partidaDTO = new Alm_partidaDTO( id, descripcion, ano, cod_item, item, n_cuenta, tipo_partida, capitulo, tipo_capitulo, importe, partida_pp, estado );

        return alm_partidaDTO;
    }

    @Override
    public Alm_partida toEntity(Alm_partidaDTO alm_partidaDTO) {
        if ( alm_partidaDTO == null ) {
            return null;
        }

        Long id = null;
        String descripcion = null;
        String ano = null;
        String cod_item = null;
        String item = null;
        String n_cuenta = null;
        String tipo_partida = null;
        String capitulo = null;
        String tipo_capitulo = null;
        String importe = null;
        String partida_pp = null;
        String estado = null;

        id = alm_partidaDTO.getId();
        descripcion = alm_partidaDTO.getDescripcion();
        ano = alm_partidaDTO.getAno();
        cod_item = alm_partidaDTO.getCod_item();
        item = alm_partidaDTO.getItem();
        n_cuenta = alm_partidaDTO.getN_cuenta();
        tipo_partida = alm_partidaDTO.getTipo_partida();
        capitulo = alm_partidaDTO.getCapitulo();
        tipo_capitulo = alm_partidaDTO.getTipo_capitulo();
        importe = alm_partidaDTO.getImporte();
        partida_pp = alm_partidaDTO.getPartida_pp();
        estado = alm_partidaDTO.getEstado();

        Alm_partida alm_partida = new Alm_partida( id, descripcion, ano, cod_item, item, n_cuenta, tipo_partida, capitulo, tipo_capitulo, importe, partida_pp, estado );

        return alm_partida;
    }

    @Override
    public void updateFromDto(Alm_partidaDTO dto, Alm_partida entity) {
        if ( dto == null ) {
            return;
        }

        entity.setId( dto.getId() );
        if ( dto.getDescripcion() != null ) {
            entity.setDescripcion( dto.getDescripcion() );
        }
        if ( dto.getAno() != null ) {
            entity.setAno( dto.getAno() );
        }
        if ( dto.getCod_item() != null ) {
            entity.setCod_item( dto.getCod_item() );
        }
        if ( dto.getItem() != null ) {
            entity.setItem( dto.getItem() );
        }
        if ( dto.getN_cuenta() != null ) {
            entity.setN_cuenta( dto.getN_cuenta() );
        }
        if ( dto.getTipo_partida() != null ) {
            entity.setTipo_partida( dto.getTipo_partida() );
        }
        if ( dto.getCapitulo() != null ) {
            entity.setCapitulo( dto.getCapitulo() );
        }
        if ( dto.getTipo_capitulo() != null ) {
            entity.setTipo_capitulo( dto.getTipo_capitulo() );
        }
        if ( dto.getImporte() != null ) {
            entity.setImporte( dto.getImporte() );
        }
        if ( dto.getPartida_pp() != null ) {
            entity.setPartida_pp( dto.getPartida_pp() );
        }
        if ( dto.getEstado() != null ) {
            entity.setEstado( dto.getEstado() );
        }
    }
}
