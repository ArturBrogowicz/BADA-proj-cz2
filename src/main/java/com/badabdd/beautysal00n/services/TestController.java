package com.badabdd.beautysal00n.services;

import com.badabdd.beautysal00n.entities.Adresy;
import com.badabdd.beautysal00n.repositories.AdresyRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/")
@RestController
public class TestController {

    private final AdresyRepository repository;

    public TestController(AdresyRepository adresyRepository) {
        this.repository = adresyRepository;
    }

    @GetMapping("/addresses")
    public List<Adresy> findAll() {
        return this.repository.findAll();
    }
}
