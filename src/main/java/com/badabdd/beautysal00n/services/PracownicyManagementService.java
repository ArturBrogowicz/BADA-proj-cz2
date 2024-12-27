package com.badabdd.beautysal00n.services;

import com.badabdd.beautysal00n.dto_views.PracownicyModeleView;
import com.badabdd.beautysal00n.entities.ModelePracy;
import com.badabdd.beautysal00n.entities.Pracownicy;
import com.badabdd.beautysal00n.repositories.ModelePracyRepository;
import com.badabdd.beautysal00n.repositories.PracownicyRepository;
import com.badabdd.beautysal00n.repositories.SprzedawcyRepository;
import com.badabdd.beautysal00n.repositories.UslugeryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PracownicyManagementService {

    private final PracownicyRepository pracownicyRepository;
    private final ModelePracyRepository modelePracyRepository;
    private final UslugeryRepository uslugeryRepository;
    private final SprzedawcyRepository sprzedawcyRepository;

    public PracownicyManagementService(PracownicyRepository pracownicyRepository,
                                       ModelePracyRepository modelePracyRepository,
                                       UslugeryRepository uslugeryRepository,
                                       SprzedawcyRepository sprzedawcyRepository) {
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

    @Transactional
    public void hirePracownika(Pracownicy newPracownik) {

        Pracownicy savedPracownik = pracownicyRepository.save(newPracownik);
        Integer id = savedPracownik.idPracownika();

        String stanowisko = modelePracyRepository.findByIdModelu(newPracownik.idModelu()).stanowisko();
        if (stanowisko.equalsIgnoreCase("USLUGER")) {
            uslugeryRepository.insertUsluger(id, 5);
        } else if (stanowisko.equalsIgnoreCase("SPRZEDAWCA")) {
            sprzedawcyRepository.insertSprzedawca(id,(double) 0, 0);
        }
    }

    @Transactional
    public void fireUpPracownika (Integer id){
        Pracownicy firedPracownik = pracownicyRepository.findByIdPracownika(id);
        Pracownicy firedPracownikUpdated = new Pracownicy(firedPracownik.idPracownika(),
                                                    firedPracownik.imie(),
                                                    firedPracownik.nazwisko(),
                                                    firedPracownik.pesel(),
                                            '0',
                                                    firedPracownik.idSalonu(),
                                                    firedPracownik.idModelu(),
                                                    firedPracownik.idAdresu());
        pracownicyRepository.save(firedPracownikUpdated);
    }
}
