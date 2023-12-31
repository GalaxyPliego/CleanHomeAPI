package com.pandemuerto.CleanHome.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/ch/test")
public class TestController {
    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/cliente")
    @PreAuthorize("hasRole('CLIENTE')")
    public String userAccess() {
        return "tablero de cliente.";
    }

    @GetMapping("/empleado")
    @PreAuthorize("hasRole('EMPLEADO')")
    public String moderatorAccess() {
        return "tablero de empleado.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "tablero de admin.";
    }
}
