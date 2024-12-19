package com.badabdd.beautysal00n.Serwisy;

import com.badabdd.beautysal00n.Encje.Pracownicy;
import com.badabdd.beautysal00n.Encje.Salony;
import com.badabdd.beautysal00n.Repozytoria.PracownicyRepository;
import com.badabdd.beautysal00n.Repozytoria.SalonyRepository;
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

