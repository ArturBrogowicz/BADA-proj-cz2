package com.badabdd.beautysal00n.Encje;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "WYKONANIE_USLUG")
public class WykonanieUslug {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_KLIENTA")
    private Klienci idKlienta;

    @Column(name = "ID_WYKONANIA", nullable = false)
    private Long idWykonania;

    @Column(name = "\"DATA\"", nullable = false)
    private LocalDate data;

    @Column(name = "CZAS_TRWANIA")
    private Long czasTrwania;

    @Column(name = "ID_USLUGI", nullable = false)
    private Long idUslugi;

    @Column(name = "ID_PRACOWNIKA")
    private Long idPracownika;

    public Long getIdPracownika() {
        return idPracownika;
    }

    public void setIdPracownika(Long idPracownika) {
        this.idPracownika = idPracownika;
    }

    public Long getIdUslugi() {
        return idUslugi;
    }

    public void setIdUslugi(Long idUslugi) {
        this.idUslugi = idUslugi;
    }

    public Long getCzasTrwania() {
        return czasTrwania;
    }

    public void setCzasTrwania(Long czasTrwania) {
        this.czasTrwania = czasTrwania;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Long getIdWykonania() {
        return idWykonania;
    }

    public void setIdWykonania(Long idWykonania) {
        this.idWykonania = idWykonania;
    }

    public Klienci getIdKlienta() {
        return idKlienta;
    }

    public void setIdKlienta(Klienci idKlienta) {
        this.idKlienta = idKlienta;
    }

}