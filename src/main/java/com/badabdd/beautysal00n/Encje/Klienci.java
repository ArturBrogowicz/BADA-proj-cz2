package com.badabdd.beautysal00n.Encje;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "KLIENCI")
public class Klienci {
    @Id
    @Column(name = "ID_KLIENTA", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ADRESU")
    private Adresy idAdresu;

    @Column(name = "IMIE", nullable = false, length = 20)
    private String imie;

    @Column(name = "NAZWISKO", nullable = false, length = 20)
    private String nazwisko;

    @Column(name = "NR_TELEFONU", length = 16)
    private String nrTelefonu;

    @Column(name = "PLEC")
    private Boolean plec;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_SALONU", nullable = false)
    private Salony idSalonu;

    @OneToMany(mappedBy = "idKlienta")
    private Set<OcenyKlientow> ocenyKlientows = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idKlienta")
    private Set<WykonanieUslug> wykonanieUslugs = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idKlienta")
    private Set<ZakupyProduktow> zakupyProduktows = new LinkedHashSet<>();

    public Set<ZakupyProduktow> getZakupyProduktows() {
        return zakupyProduktows;
    }

    public void setZakupyProduktows(Set<ZakupyProduktow> zakupyProduktows) {
        this.zakupyProduktows = zakupyProduktows;
    }

    public Set<WykonanieUslug> getWykonanieUslugs() {
        return wykonanieUslugs;
    }

    public void setWykonanieUslugs(Set<WykonanieUslug> wykonanieUslugs) {
        this.wykonanieUslugs = wykonanieUslugs;
    }

    public Set<OcenyKlientow> getOcenyKlientows() {
        return ocenyKlientows;
    }

    public void setOcenyKlientows(Set<OcenyKlientow> ocenyKlientows) {
        this.ocenyKlientows = ocenyKlientows;
    }

    public Salony getIdSalonu() {
        return idSalonu;
    }

    public void setIdSalonu(Salony idSalonu) {
        this.idSalonu = idSalonu;
    }

    public Boolean getPlec() {
        return plec;
    }

    public void setPlec(Boolean plec) {
        this.plec = plec;
    }

    public String getNrTelefonu() {
        return nrTelefonu;
    }

    public void setNrTelefonu(String nrTelefonu) {
        this.nrTelefonu = nrTelefonu;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Adresy getIdAdresu() {
        return idAdresu;
    }

    public void setIdAdresu(Adresy idAdresu) {
        this.idAdresu = idAdresu;
    }

}