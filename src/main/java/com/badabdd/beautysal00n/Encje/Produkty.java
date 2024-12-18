package com.badabdd.beautysal00n.Encje;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "PRODUKTY")
public class Produkty {
    @Id
    @Column(name = "ID_PRODUKTU", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_SALONU")
    private Salony idSalonu;

    @Column(name = "NAZWA", nullable = false, length = 50)
    private String nazwa;

    @Column(name = "CENA", nullable = false, precision = 10, scale = 2)
    private BigDecimal cena;

    @Column(name = "OPIS", nullable = false, length = 500)
    private String opis;

    @Column(name = "LICZBA_SZTUK", nullable = false)
    private Long liczbaSztuk;

    @Column(name = "CZY_OFEROWANY", nullable = false)
    private Boolean czyOferowany = false;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_PRODUCENTA", nullable = false)
    private Producenci idProducenta;

    public Producenci getIdProducenta() {
        return idProducenta;
    }

    public void setIdProducenta(Producenci idProducenta) {
        this.idProducenta = idProducenta;
    }

    public Boolean getCzyOferowany() {
        return czyOferowany;
    }

    public void setCzyOferowany(Boolean czyOferowany) {
        this.czyOferowany = czyOferowany;
    }

    public Long getLiczbaSztuk() {
        return liczbaSztuk;
    }

    public void setLiczbaSztuk(Long liczbaSztuk) {
        this.liczbaSztuk = liczbaSztuk;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public BigDecimal getCena() {
        return cena;
    }

    public void setCena(BigDecimal cena) {
        this.cena = cena;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Salony getIdSalonu() {
        return idSalonu;
    }

    public void setIdSalonu(Salony idSalonu) {
        this.idSalonu = idSalonu;
    }

}