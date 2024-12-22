package com.badabdd.beautysal00n.services;

import com.badabdd.beautysal00n.dto_views.PracownicyModeleView;
import com.badabdd.beautysal00n.entities.ModelePracy;
import com.badabdd.beautysal00n.entities.Pracownicy;
import com.badabdd.beautysal00n.repositories.ModelePracyRepository;
import com.badabdd.beautysal00n.repositories.PracownicyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PracownicyManagementService {

    private final PracownicyRepository pracownicyRepository;
    private final ModelePracyRepository modelePracyRepository;

    public PracownicyManagementService(PracownicyRepository pracownicyRepository, ModelePracyRepository modelePracyRepository) {
        this.pracownicyRepository = pracownicyRepository;
        this.modelePracyRepository = modelePracyRepository;
    }

    public List<PracownicyModeleView> getAllPracownicyWithModele() {
        List<Pracownicy> pracownicy = pracownicyRepository.findAll();
        return pracownicy.stream().map(pracownik -> {
            ModelePracy model = modelePracyRepository.findByIdModelu(pracownik.idModelu());
            return new PracownicyModeleView(pracownik.imie(), pracownik.nazwisko(), model.stanowisko(), model.trybPracy(), model.pensja());
        }).toList();
    }
}
