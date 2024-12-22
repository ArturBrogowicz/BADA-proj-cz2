package com.badabdd.beautysal00n.controllers;

import com.badabdd.beautysal00n.dto_views.PracownicyModeleView;
import com.badabdd.beautysal00n.services.PracownicyManagementService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("admin/pracownicy/")
public class PracownicyController {

    private final PracownicyManagementService pracownicyManagementService;

    public PracownicyController(PracownicyManagementService pracownicyManagementService) {
        this.pracownicyManagementService = pracownicyManagementService;
    }

    @GetMapping("/list")
    public List<PracownicyModeleView> listAll() {
        return this.pracownicyManagementService.getAllPracownicyWithModele();
    }
}
