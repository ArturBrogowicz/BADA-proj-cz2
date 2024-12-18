package com.badabdd.beautysal00n.Encje;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "ZAKUPY_PRODUKTOW")
public class ZakupyProduktow {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PRACOWNIKA")
    private Pracownicy idPracownika;

    @Column(name = "ID_ZAKUPU", nullable = false)
    private Long idZakupu;

    @Column(name = "\"DATA\"", nullable = false)
    private LocalDate data;

    @Column(name = "CZY_DOSTAWA", nullable = false)
    private Boolean czyDostawa = false;

    @Column(name = "ID_KLIENTA", nullable = false)
    private Long idKlienta;

    @Column(name = "ID_PRODUKTU", nullable = false)
    private Long idProduktu;

    public Long getIdProduktu() {
        return idProduktu;
    }

    public void setIdProduktu(Long idProduktu) {
        this.idProduktu = idProduktu;
    }

    public Long getIdKlienta() {
        return idKlienta;
    }

    public void setIdKlienta(Long idKlienta) {
        this.idKlienta = idKlienta;
    }

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

    public Long getIdZakupu() {
        return idZakupu;
    }

    public void setIdZakupu(Long idZakupu) {
        this.idZakupu = idZakupu;
    }

    public Pracownicy getIdPracownika() {
        return idPracownika;
    }

    public void setIdPracownika(Pracownicy idPracownika) {
        this.idPracownika = idPracownika;
    }

}