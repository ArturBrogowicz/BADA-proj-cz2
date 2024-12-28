package com.badabdd.beautysal00n.services;

import com.badabdd.beautysal00n.entities.Produkty;
import com.badabdd.beautysal00n.entities.Uslugi;
import com.badabdd.beautysal00n.repositories.ProduktyRepository;
import com.badabdd.beautysal00n.repositories.UslugiRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SalesService {

    private final ProduktyRepository produktyRepository;
    private final UslugiRepository uslugiRepository;

    public SalesService(ProduktyRepository produktyRepository, UslugiRepository uslugiRepository) {
        this.produktyRepository = produktyRepository;
        this.uslugiRepository = uslugiRepository;
    }

    @Transactional
    public void addNewProdukt(Produkty newProdukt) {
        produktyRepository.save(newProdukt);
    }

    @Transactional
    public void acceptDeliveryProduktow(Integer idProduktu, Integer amount) {
        Produkty deliveredProdukt = produktyRepository.findByIdProduktu(idProduktu);
        Produkty updatedAmount = new Produkty(deliveredProdukt.idProduktu(),
                deliveredProdukt.nazwa(), deliveredProdukt.cena(), deliveredProdukt.opis(),
                deliveredProdukt.liczbaSztuk() + amount, deliveredProdukt.czyOferowany(),
                deliveredProdukt.idProducenta(), deliveredProdukt.idSalonu());
        produktyRepository.save(updatedAmount);
    }

    @Transactional
    public void withdrawProduktFromOffer(Integer idProduktu) {
        Produkty produktToWithdraw = produktyRepository.findByIdProduktu(idProduktu);
        Produkty withdrawnProdukt = new Produkty(produktToWithdraw.idProduktu(), produktToWithdraw.nazwa(),
                produktToWithdraw.cena(), produktToWithdraw.opis(), produktToWithdraw.liczbaSztuk(),
                '0', produktToWithdraw.idProducenta(), produktToWithdraw.idSalonu());
        produktyRepository.save(withdrawnProdukt);
    }

    @Transactional
    public void addNewUsluga(Uslugi newUsluga) {
        uslugiRepository.save(newUsluga);
    }

    @Transactional
    public void withdrawUslugeFromOffer(Integer idUslugi) {
        Uslugi uslugaToWithdraw = uslugiRepository.findByIdUslugi(idUslugi);
        Uslugi withdrawnUsluga = new Uslugi(uslugaToWithdraw.idUslugi(), uslugaToWithdraw.nazwa(),
                uslugaToWithdraw.opis(), uslugaToWithdraw.koszt(), '0', uslugaToWithdraw.idSalonu());
        uslugiRepository.save(withdrawnUsluga);
    }
}
