package com.gmao.gmao_backend.admin;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncryptionExample {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "Qwerty123#";
        String encodedPassword = encoder.encode(rawPassword);

        System.out.println("Contraseña cifrada: " + encodedPassword);
    }
}