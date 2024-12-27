package com.badabdd.beautysal00n.controllers;

import com.badabdd.beautysal00n.dto_views.PracownicyModeleView;
import com.badabdd.beautysal00n.entities.Pracownicy;
import com.badabdd.beautysal00n.services.PracownicyManagementService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public void addPracownik(@RequestBody Pracownicy newPracownik) {
        pracownicyManagementService.hirePracownika(newPracownik);
    }
    @PutMapping("/delete")
    public void deletePracownik(@RequestBody Integer id) {
        pracownicyManagementService.fireUpPracownika(id);
    }
}
