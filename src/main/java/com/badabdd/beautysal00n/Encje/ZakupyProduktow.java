package com.badabdd.beautysal00n.Encje;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "ZAKUPY_PRODUKTOW")
public class ZakupyProduktow {
    @Id
    @Column(name = "ID_ZAKUPU", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_KLIENTA")
    private Klienci idKlienta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PRACOWNIKA")
    private Pracownicy idPracownika;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PRODUKTU")
    private Produkty idProduktu;

    @Column(name = "\"DATA\"", nullable = false)
    private LocalDate data;

    @Column(name = "CZY_DOSTAWA", nullable = false)
    private Boolean czyDostawa = false;

    public Boolean getCzyDostawa() {
        return czyDostawa;
    }

    public void setCzyDostawa(Boolean czyDostawa) {
        this.czyDostawa = czyDostawa;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Produkty getIdProduktu() {
        return idProduktu;
    }

    public void setIdProduktu(Produkty idProduktu) {
        this.idProduktu = idProduktu;
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