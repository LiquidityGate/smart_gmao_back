package com.gmao.gmao_backend.model;

public class AuthenticationResponse {

    private String jwt;
    private Long sessionId;
    private Long usuarioId;

    // Constructor
    public AuthenticationResponse(String jwt, Long sessionId, Long usuarioId) {
        this.jwt = jwt;
        this.sessionId = sessionId;
        this.usuarioId = usuarioId;
    }

    // Getters y setters
    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

}
