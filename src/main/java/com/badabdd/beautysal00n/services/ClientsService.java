package com.badabdd.beautysal00n.services;

import com.badabdd.beautysal00n.entities.Klienci;
import com.badabdd.beautysal00n.entities.OcenyKlientow;
import com.badabdd.beautysal00n.entities.Uslugery;
import com.badabdd.beautysal00n.repositories.KlienciRepository;
import com.badabdd.beautysal00n.repositories.OcenyKlientowRepository;
import com.badabdd.beautysal00n.repositories.UslugeryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.OptionalDouble;

@Service
public class ClientsService {

    private final KlienciRepository klienciRepository;
    private final UslugeryRepository uslugeryRepository;
    private final OcenyKlientowRepository ocenyKlientowRepository;

    public ClientsService(KlienciRepository klienciRepository, UslugeryRepository uslugeryRepository, OcenyKlientowRepository ocenyKlientowRepository) {
        this.klienciRepository = klienciRepository;
        this.uslugeryRepository = uslugeryRepository;
        this.ocenyKlientowRepository = ocenyKlientowRepository;
    }

    @Transactional
    public void registerNewKlienta(Klienci newKlient) {
        this.klienciRepository.save(newKlient);
    }

    @Transactional
    public void giveRatingToUsluger(Integer idPracownika, OcenyKlientow newOcena) {
        ocenyKlientowRepository.save(newOcena);
        List<OcenyKlientow> ocenyUslugera = ocenyKlientowRepository.findAllByIdPracownika(idPracownika);
        OptionalDouble srednia = ocenyUslugera.stream().mapToDouble(OcenyKlientow::wysokosc).average();
        Integer processedSrednia = Math.max(1, Math.min((int) Math.round(srednia.orElse(0.0)), 10));
        Uslugery uslugerToUpdate = uslugeryRepository.findByIdPracownika(idPracownika);
        Uslugery updatedUsluger = new Uslugery(uslugerToUpdate.idPracownika(), processedSrednia);
        uslugeryRepository.save(updatedUsluger);
    }
}
