package com.badabdd.beautysal00n.services;

import com.badabdd.beautysal00n.dto_views.PracownicyModeleView;
import com.badabdd.beautysal00n.dto_views.PracownicyView;
import com.badabdd.beautysal00n.entities.Adresy;
import com.badabdd.beautysal00n.entities.ModelePracy;
import com.badabdd.beautysal00n.entities.Pracownicy;
import com.badabdd.beautysal00n.repositories.*;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PracownicyManagementService {

    private final PracownicyRepository pracownicyRepository;
    private final ModelePracyRepository modelePracyRepository;
    private final UslugeryRepository uslugeryRepository;
    private final SprzedawcyRepository sprzedawcyRepository;
    private final AdresyRepository adresyRepository;


    public PracownicyManagementService(PracownicyRepository pracownicyRepository,
                                       ModelePracyRepository modelePracyRepository,
                                       UslugeryRepository uslugeryRepository,
                                       SprzedawcyRepository sprzedawcyRepository, AdresyRepository adresyRepository) {
        this.pracownicyRepository = pracownicyRepository;
        this.modelePracyRepository = modelePracyRepository;
        this.uslugeryRepository = uslugeryRepository;
        this.sprzedawcyRepository = sprzedawcyRepository;
        this.adresyRepository = adresyRepository;
    }

    public List<PracownicyModeleView> getAllPracownicyWithModele() {
        List<Pracownicy> pracownicy = pracownicyRepository.findAll();
        return pracownicy.stream().filter(pracownik -> pracownik.czyPracuje() == '1').map(pracownik -> {
            ModelePracy model = modelePracyRepository.findByIdModelu(pracownik.idModelu());
            return new PracownicyModeleView(pracownik.idPracownika(),pracownik.imie(), pracownik.nazwisko(), model.stanowisko(), model.trybPracy(), model.pensja());
        }).toList();
    }

    @Transactional
    public void hirePracownika(PracownicyView newPracownik) {
        ModelePracy model =  modelePracyRepository.findByAttributes(newPracownik.stanowisko(),
                newPracownik.trybPracy(), newPracownik.pensja());
        if(model == null) {
            modelePracyRepository.save(new ModelePracy(null, newPracownik.stanowisko(), newPracownik.trybPracy(), newPracownik.pensja()));
            model =  modelePracyRepository.findByAttributes(newPracownik.stanowisko(),
                    newPracownik.trybPracy(), newPracownik.pensja());
        }
        Adresy adresy = adresyRepository.findByAttributes(newPracownik.miasto(), newPracownik.ulica(),
                newPracownik.kodPocztowy(),
                newPracownik.nrBudynku(), newPracownik.nrLokalu());
        if(adresy == null) {
            adresyRepository.save(new Adresy(null, newPracownik.miasto(), newPracownik.ulica(),
                    newPracownik.kodPocztowy(),
                    newPracownik.nrBudynku(), newPracownik.nrLokalu()));
            adresy = adresyRepository.findByAttributes(newPracownik.miasto(), newPracownik.ulica(),
                    newPracownik.kodPocztowy(),
                    newPracownik.nrBudynku(), newPracownik.nrLokalu());
        }

        Pracownicy savedPracownik = pracownicyRepository.save(new Pracownicy(null, newPracownik.imie(), newPracownik.nazwisko(), newPracownik.pesel(), '1', 1, model.idModelu(), adresy.idAdresu()));
        Integer id = savedPracownik.idPracownika();

        String stanowisko = model.stanowisko();
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

    @Transactional
    public void changeModelOfPracownik(String stanowisko, Integer idPracownika){
        Pracownicy pracownik = pracownicyRepository.findByIdPracownika(idPracownika);
        ModelePracy modelPracy = modelePracyRepository.findByStanowisko(stanowisko);
        Pracownicy changedPracownik = new Pracownicy(pracownik.idPracownika(),
                pracownik.imie(),
                pracownik.nazwisko(),
                pracownik.pesel(),
                pracownik.czyPracuje(),
                pracownik.idSalonu(),
                modelPracy.idModelu(),
                pracownik.idAdresu());
        pracownicyRepository.save(changedPracownik);
    }

    @Transactional
    public void addModelPracy(ModelePracy modelPracy) {
        if (modelPracy.stanowisko().equals("usluger") || modelPracy.stanowisko().equals("menadzer") || modelPracy.stanowisko().equals("sprzedawca")) {
            modelePracyRepository.save(modelPracy);
        }
        else{
            throw new IllegalArgumentException("Unsupported stanowisko for model");
        }
    }
    public PracownicyView getPracownicyById(Integer id) {
        Pracownicy pracownik = pracownicyRepository.findByIdPracownika(id);
        ModelePracy model = modelePracyRepository.findByIdModelu(pracownik.idModelu());
        Adresy adresy = adresyRepository.findByIdAdresu(pracownik.idAdresu());
        return new PracownicyView(pracownik.imie(), pracownik.nazwisko(), pracownik.pesel(),
                adresy.miasto(), adresy.ulica(), adresy.kodPocztowy(), adresy.nrBudynku(),
                adresy.nrLokalu(), model.stanowisko(), model.trybPracy(), model.pensja());
    }
}
