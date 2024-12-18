package com.badabdd.beautysal00n.Encje;

import jakarta.persistence.*;

@Entity
@Table(name = "OCENY_KLIENTOW")
public class OcenyKlientow {
    @Id
    @Column(name = "ID_OCENY", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PRACOWNIKA")
    private Pracownicy idPracownika;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_KLIENTA")
    private Klienci idKlienta;

    @Column(name = "WYSOKOSC", nullable = false)
    private Long wysokosc;

    @Column(name = "TRESC", length = 2500)
    private String tresc;

    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }

    public Long getWysokosc() {
        return wysokosc;
    }

    public void setWysokosc(Long wysokosc) {
        this.wysokosc = wysokosc;
    }

    public Klienci getIdKlienta() {
        return idKlienta;
    }

    public void setIdKlienta(Klienci idKlienta) {
        this.idKlienta = idKlienta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pracownicy getIdPracownika() {
        return idPracownika;
    }

    public void setIdPracownika(Pracownicy idPracownika) {
        this.idPracownika = idPracownika;
    }

}