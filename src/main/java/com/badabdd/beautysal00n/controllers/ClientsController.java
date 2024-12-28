package com.badabdd.beautysal00n.controllers;

import com.badabdd.beautysal00n.entities.Klienci;
import com.badabdd.beautysal00n.entities.OcenyKlientow;
import com.badabdd.beautysal00n.services.ClientsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientsController {

    private final ClientsService clientsService;

    public ClientsController(ClientsService clientsService) {
        this.clientsService = clientsService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public void registerNewKlienta(@RequestBody Klienci newKlient) {
        clientsService.registerNewKlienta(newKlient);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping("/rateusluger/{idPracownika}")
    public void giveRatingToUslguer(@PathVariable Integer idPracownika, @RequestBody OcenyKlientow newOcena) {
        clientsService.giveRatingToUsluger(idPracownika, newOcena);
    }
}
