package com.badabdd.beautysal00n.Encje;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "SPRZEDAWCY")
public class Sprzedawcy {
    @Id
    @Column(name = "ID_PRACOWNIKA", nullable = false)
    private Long id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PRACOWNIKA")
    private Pracownicy pracownicy;

    @Column(name = "LACZNA_SPRZEDAZ", nullable = false, precision = 10, scale = 2)
    private BigDecimal lacznaSprzedaz;

    @Column(name = "LICZBA_TRANSAKCJI", nullable = false)
    private Long liczbaTransakcji;

    public Long getLiczbaTransakcji() {
        return liczbaTransakcji;
    }

    public void setLiczbaTransakcji(Long liczbaTransakcji) {
        this.liczbaTransakcji = liczbaTransakcji;
    }

    public BigDecimal getLacznaSprzedaz() {
        return lacznaSprzedaz;
    }

    public void setLacznaSprzedaz(BigDecimal lacznaSprzedaz) {
        this.lacznaSprzedaz = lacznaSprzedaz;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pracownicy getPracownicy() {
        return pracownicy;
    }

    public void setPracownicy(Pracownicy pracownicy) {
        this.pracownicy = pracownicy;
    }

}