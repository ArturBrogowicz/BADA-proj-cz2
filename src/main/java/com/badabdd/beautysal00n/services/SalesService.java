package com.badabdd.beautysal00n.services;

import com.badabdd.beautysal00n.entities.*;
import com.badabdd.beautysal00n.repositories.ProduktyRepository;
import com.badabdd.beautysal00n.repositories.SprzedawcyRepository;
import com.badabdd.beautysal00n.repositories.UslugiRepository;
import com.badabdd.beautysal00n.repositories.ZakupyProduktowRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class SalesService {

    private final ProduktyRepository produktyRepository;
    private final UslugiRepository uslugiRepository;
    private final ZakupyProduktowRepository zakupyProduktowRepository;
    private final SprzedawcyRepository sprzedawcyRepository;

    public SalesService(ProduktyRepository produktyRepository, UslugiRepository uslugiRepository,
                        ZakupyProduktowRepository zakupyProduktowRepository, SprzedawcyRepository sprzedawcyRepository) {
        this.produktyRepository = produktyRepository;
        this.uslugiRepository = uslugiRepository;
        this.zakupyProduktowRepository = zakupyProduktowRepository;
        this.sprzedawcyRepository = sprzedawcyRepository;
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
    @Transactional
    public void saleProduktInSalon(Integer idProduktu, Integer amount, Integer idSprzedawcy, LocalDateTime data, Integer idKlienta) {
        if(produktyRepository.findByIdProduktu(idProduktu) == null) {
            throw new IllegalArgumentException("There is no such produkt");
        } else if (produktyRepository.findByIdProduktu(idProduktu).liczbaSztuk() < amount) {
            System.out.println("Not enough produkt in Salon, you can order at most "+ produktyRepository.findByIdProduktu(idProduktu).liczbaSztuk() +" of produkt");
        } else if (idKlienta == null) {
            // odesłanie do rejestracji klienta
        } else {
            zakupyProduktowRepository.save(new ZakupyProduktow(null, data, '0', idKlienta, idProduktu, idSprzedawcy));
            Sprzedawcy currentSprzedawca = sprzedawcyRepository.findSprzedawcyByIdPracownika(idSprzedawcy);
            Produkty currentProdukt = produktyRepository.findByIdProduktu(idProduktu);
            sprzedawcyRepository.save(new Sprzedawcy(idSprzedawcy,
                    currentSprzedawca.lacznaSprzedaz()+currentProdukt.cena()*amount,
                    currentSprzedawca.liczbaTransakcji()+1));
            produktyRepository.save(new Produkty(currentProdukt.idProduktu(),currentProdukt.nazwa(),
                    currentProdukt.cena(),currentProdukt.opis(),currentProdukt.liczbaSztuk()-amount,
                    currentProdukt.czyOferowany(),currentProdukt.idProducenta(), currentProdukt.idSalonu()));
        }
    }
}
