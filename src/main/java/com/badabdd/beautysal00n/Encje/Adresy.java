package com.badabdd.beautysal00n.Encje;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Adresy {
    @Id
    @Column(name = "ID_ADRESU", nullable = false)
    private Long id;

    @Column(name = "MIASTO", nullable = false, length = 40)
    private String miasto;

    @Column(name = "ULICA", nullable = false, length = 40)
    private String ulica;

    @Column(name = "KOD_POCZTOWY", nullable = false, length = 6)
    private String kodPocztowy;

    @Column(name = "NR_BUDYNKU", nullable = false)
    private Long nrBudynku;

    @Column(name = "NR_LOKALU")
    private Long nrLokalu;

    @OneToMany(mappedBy = "idAdresu")
    private Set<Klienci> kliencis = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idAdresu")
    private Set<Pracownicy> pracownicies = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idAdresu")
    private Set<Salony> salonies = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idAdresu")
    private Set<Wlasciciele> wlascicieles = new LinkedHashSet<>();

    public Set<Wlasciciele> getWlascicieles() {
        return wlascicieles;
    }

    public void setWlascicieles(Set<Wlasciciele> wlascicieles) {
        this.wlascicieles = wlascicieles;
    }

    public Set<Salony> getSalonies() {
        return salonies;
    }

    public void setSalonies(Set<Salony> salonies) {
        this.salonies = salonies;
    }

    public Set<Pracownicy> getPracownicies() {
        return pracownicies;
    }

    public void setPracownicies(Set<Pracownicy> pracownicies) {
        this.pracownicies = pracownicies;
    }

    public Set<Klienci> getKliencis() {
        return kliencis;
    }

    public void setKliencis(Set<Klienci> kliencis) {
        this.kliencis = kliencis;
    }

    public Long getNrLokalu() {
        return nrLokalu;
    }

    public void setNrLokalu(Long nrLokalu) {
        this.nrLokalu = nrLokalu;
    }

    public Long getNrBudynku() {
        return nrBudynku;
    }

    public void setNrBudynku(Long nrBudynku) {
        this.nrBudynku = nrBudynku;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
