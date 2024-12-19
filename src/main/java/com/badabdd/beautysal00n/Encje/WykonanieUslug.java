package com.badabdd.beautysal00n.Encje;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "WYKONANIE_USLUG")
public class WykonanieUslug {
    @Id
    @Column(name = "ID_WYKONANIA", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_KLIENTA")
    private Klienci idKlienta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PRACOWNIKA")
    private Pracownicy idPracownika;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USLUGI")
    private Uslugi idUslugi;

    @Column(name = "\"DATA\"", nullable = false)
    private LocalDate data;

    @Column(name = "CZAS_TRWANIA")
    private Long czasTrwania;

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

    public Uslugi getIdUslugi() {
        return idUslugi;
    }

    public void setIdUslugi(Uslugi idUslugi) {
        this.idUslugi = idUslugi;
    }

    public Pracownicy getIdPracownika() {
        return idPracownika;
    }

    public void setIdPracownika(Pracownicy idPracownika) {
        this.idPracownika = idPracownika;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Klienci getIdKlienta() {
        return idKlienta;
    }

    public void setIdKlienta(Klienci idKlienta) {
        this.idKlienta = idKlienta;
    }

}