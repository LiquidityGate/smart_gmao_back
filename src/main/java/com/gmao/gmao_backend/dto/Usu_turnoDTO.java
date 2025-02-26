package com.gmao.gmao_backend.dto;

public class Usu_turnoDTO {

    private Long id;
    private String turno;
    private String horario;
    private String descanso;
    private String estado;

    public Usu_turnoDTO() {}

    public Usu_turnoDTO(Long id, String turno, String horario, String descanso, String estado) {
        this.id = id;
        this.turno = turno;
        this.horario = horario;
        this.descanso = descanso;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getDescanso() {
        return descanso;
    }

    public void setDescanso(String descanso) {
        this.descanso = descanso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}