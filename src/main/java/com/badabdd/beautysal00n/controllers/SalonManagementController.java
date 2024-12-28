package com.badabdd.beautysal00n.controllers;

import com.badabdd.beautysal00n.dto_views.WlascicieleView;
import com.badabdd.beautysal00n.entities.Narzedzia;
import com.badabdd.beautysal00n.entities.Wlasciciele;
import com.badabdd.beautysal00n.services.SalonManagementService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/salon")
public class SalonManagementController {

    private final SalonManagementService salonManagementService;

    public SalonManagementController(SalonManagementService salonManagementService) {
        this.salonManagementService = salonManagementService;
    }

    @GetMapping("/wlasciciele/list")
    public List<WlascicieleView> listWlascicieli() {
        return salonManagementService.listWlasciceli();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/wlasciciele/add")
    public void addWlasciciela(@RequestBody Wlasciciele newWlasciciel) {
        salonManagementService.addWlasciciela(newWlasciciel);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/wlasciciele/delete/{id}")
    public void deleteWlasciciela(@PathVariable Integer id) {
        salonManagementService.deleteWlasciciela(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/narzedzia/add")
    public void acquireNewNarzedzie(@RequestBody Narzedzia newNarzedzie) {
        salonManagementService.acquireNewNarzedzie(newNarzedzie);
    }
}
