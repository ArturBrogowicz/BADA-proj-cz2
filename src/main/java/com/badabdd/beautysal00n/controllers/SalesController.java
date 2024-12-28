package com.badabdd.beautysal00n.controllers;

import com.badabdd.beautysal00n.entities.Klienci;
import com.badabdd.beautysal00n.entities.Produkty;
import com.badabdd.beautysal00n.entities.Uslugi;
import com.badabdd.beautysal00n.services.SalesService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sales")
public class SalesController {

    private final SalesService salesService;

    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/produkty/add")
    public void addNewProdukt(@RequestBody Produkty newProdukt) {
        salesService.addNewProdukt(newProdukt);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/produkty/delivery/{idProduktu}/{amount}")
    public void acceptDeliveryProduktow(@PathVariable Integer idProduktu, @PathVariable Integer amount) {
        salesService.acceptDeliveryProduktow(idProduktu, amount);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/produkty/withdraw/{idProduktu}")
    public void withdrawProduktFromOffer(@PathVariable Integer idProduktu) {
        salesService.withdrawProduktFromOffer(idProduktu);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/uslugi/add")
    public void addNewUsluga(@RequestBody Uslugi newUsluga) {
        salesService.addNewUsluga(newUsluga);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/uslugi/withdraw/{idUslugi}")
    public void withdrawUslugeFromOffer(@PathVariable Integer idUslugi) {
        salesService.withdrawUslugeFromOffer(idUslugi);
    }

}
