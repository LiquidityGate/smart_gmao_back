package com.gmao.gmao_backend.exception;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.jsonwebtoken.security.SecurityException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<Object> handleBadCredentialsException(BadCredentialsException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("status", HttpStatus.FORBIDDEN.value());
        body.put("error", "Credenciales incorrectas");
        body.put("message", "Usuario o contraseña incorrectos. Por favor verifica tus credenciales.");
        return new ResponseEntity<>(body, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<String> handleAccessDeniedException(AccessDeniedException ex) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access Denied");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        ex.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
    }

    @ExceptionHandler(SecurityException.class)
    public ResponseEntity<String> handleInvalidJwtSignature(SecurityException ex) {
        // Maneja la excepción de firma JWT no válida
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("JWT signature is invalid. Access denied.");
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<String> handleExpiredJwt(ExpiredJwtException ex) {
        // Maneja la excepción de JWT caducado
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("JWT token has expired. Access denied.");
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<String> handleAuthenticationException(AuthenticationException ex) {
        // Maneja excepciones de autenticación en general
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication error. Access denied.");
    }

    @ExceptionHandler(SignatureException.class)
    public ResponseEntity<String> handleSignatureException(SignatureException ex) {
        // Maneja la excepción de firma JWT no válida
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("JWT signature is invalid. Access denied.");
    }

    // Puedes agregar más excepciones personalizadas si es necesario

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(
            ResourceNotFoundException ex, WebRequest request) {

        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }





}