package com.badabdd.beautysal00n.services;

import com.badabdd.beautysal00n.dto_views.ProduktyDetailsView;
import com.badabdd.beautysal00n.dto_views.ProduktyView;
import com.badabdd.beautysal00n.entities.*;
import com.badabdd.beautysal00n.repositories.*;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SalesService {

    private final ProduktyRepository produktyRepository;
    private final UslugiRepository uslugiRepository;
    private final ZakupyProduktowRepository zakupyProduktowRepository;
    private final SprzedawcyRepository sprzedawcyRepository;
    private final WykonanieUslugRepository wykonanieUslugRepository;
    private final RezerwacjeUslugerowRepository rezerwacjeUslugerowRepository;
    private final PracownicyRepository pracownicyRepository;
    private final ProducenciRepository producenciRepository;

    public SalesService(ProduktyRepository produktyRepository, UslugiRepository uslugiRepository,
                        ZakupyProduktowRepository zakupyProduktowRepository, SprzedawcyRepository sprzedawcyRepository,
                        WykonanieUslugRepository wykonanieUslugRepository, RezerwacjeUslugerowRepository rezerwacjeUslugerowRepository,
                        PracownicyRepository pracownicyRepository, ProducenciRepository producenciRepository) {
        this.produktyRepository = produktyRepository;
        this.uslugiRepository = uslugiRepository;
        this.zakupyProduktowRepository = zakupyProduktowRepository;
        this.sprzedawcyRepository = sprzedawcyRepository;
        this.wykonanieUslugRepository = wykonanieUslugRepository;
        this.rezerwacjeUslugerowRepository = rezerwacjeUslugerowRepository;
        this.pracownicyRepository = pracownicyRepository;
        this.producenciRepository = producenciRepository;
    }

    public List<ProduktyView> listAllOfferedProdukty() {
        List<Produkty> produkty = produktyRepository.findAll();
        return produkty.stream().filter(produkt -> produkt.czyOferowany() == '1')
                .map(produkt -> {
                    Producenci producent = producenciRepository.findByIdProducenta(produkt.idProducenta());
                    return new ProduktyView(
                            produkt.idProduktu(),
                            produkt.nazwa(),
                            produkt.cena(),
                            produkt.liczbaSztuk(),
                            producent.nazwa()
                    );
                }).toList();
    }

    public ProduktyDetailsView getProduktyDetails(int id) {
        Produkty produkt = produktyRepository.findByIdProduktu(id);
        return new ProduktyDetailsView(produkt.nazwa(),produkt.opis());
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
    public void saleProduktOnline(Integer idProduktu, Integer amount, LocalDateTime data, Integer idKlienta) {
        if(produktyRepository.findByIdProduktu(idProduktu) == null) {
            throw new IllegalArgumentException("There is no such produkt");
        } else if (produktyRepository.findByIdProduktu(idProduktu).liczbaSztuk() < amount) {
            System.out.println("Not enough produkt in Salon, you can order at most "+ produktyRepository.findByIdProduktu(idProduktu).liczbaSztuk() +" of produkt");
        } else if (idKlienta == null) {
            // odesłanie do rejestracji klienta
        } else {
            zakupyProduktowRepository.save(new ZakupyProduktow(null, data, '0', idKlienta, idProduktu,null));
            Produkty currentProdukt = produktyRepository.findByIdProduktu(idProduktu);
            produktyRepository.save(new Produkty(currentProdukt.idProduktu(),currentProdukt.nazwa(),
                    currentProdukt.cena(),currentProdukt.opis(),currentProdukt.liczbaSztuk()-amount,
                    currentProdukt.czyOferowany(),currentProdukt.idProducenta(), currentProdukt.idSalonu()));
        }
    }
    @Transactional
    public void reservationOfUsluga(Integer idUslugi, Integer idKlienta, LocalDateTime data, Integer czasTrwania) {
        Integer newIdWykonania = wykonanieUslugRepository.getMaxId() + 1; // Generowanie unikalnego ID
        wykonanieUslugRepository.insertWykonanieUslugi(newIdWykonania, data, czasTrwania, idUslugi, idKlienta, pracownicyRepository.findPracownikWhoPracuje().idPracownika());
        Integer newIdRezerwacji = rezerwacjeUslugerowRepository.getMaxId() + 1;
        rezerwacjeUslugerowRepository.insertRezerwacjaUslugerow(newIdRezerwacji, pracownicyRepository.findPracownikWhoPracuje().idPracownika(), data);
    }
}
