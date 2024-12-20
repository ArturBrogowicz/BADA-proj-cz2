package com.badabdd.beautysal00n.services;

import com.badabdd.beautysal00n.entities_deprecated.Pracownicy;
import com.badabdd.beautysal00n.entities_deprecated.Salony;
import com.badabdd.beautysal00n.repositories.PracownicyRepository;
import com.badabdd.beautysal00n.repositories.SalonyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final SalonyRepository salonyRepository;
    private final PracownicyRepository pracownicyRepository;

    public AdminService(SalonyRepository salonyRepository, PracownicyRepository pracownicyRepository) {
        this.salonyRepository = salonyRepository;
        this.pracownicyRepository = pracownicyRepository;
    }

    public List<Salony> getSalonyByName(String nazwa) {
        return salonyRepository.findByNazwa(nazwa);
    }
    public List<Pracownicy> getPracownicyBySurname(String surname) {
        return pracownicyRepository.findByNazwisko(surname);
    }
    public List<Pracownicy> getTopPracownicyBySalary(){
        return pracownicyRepository.findTopByPensja();
    }
}

