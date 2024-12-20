package com.badabdd.beautysal00n.entities_deprecated;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "PRACOWNICY")
public class Pracownicy {
    @Id
    @Column(name = "ID_PRACOWNIKA", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ADRESU")
    private Adresy idAdresu;

    @Column(name = "IMIE", nullable = false, length = 20)
    private String imie;

    @Column(name = "NAZWISKO", nullable = false, length = 20)
    private String nazwisko;

    @Column(name = "PESEL", length = 11)
    private String pesel;

    @Column(name = "CZY_PRACUJE")
    private Boolean czyPracuje;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_SALONU", nullable = false)
    private Salony idSalonu;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_MODELU", nullable = false)
    private ModelePracy idModelu;

    @OneToMany(mappedBy = "idPracownika")
    private Set<OcenyKlientow> ocenyKlientows = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idPracownika")
    private Set<RezerwacjeUslugerow> rezerwacjeUslugerows = new LinkedHashSet<>();

    @OneToOne(mappedBy = "pracownicy")
    private Sprzedawcy sprzedawcy;

    @OneToMany(mappedBy = "idPracownika")
    private Set<WykonanieUslug> wykonanieUslugs = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idPracownika")
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

    public Sprzedawcy getSprzedawcy() {
        return sprzedawcy;
    }

    public void setSprzedawcy(Sprzedawcy sprzedawcy) {
        this.sprzedawcy = sprzedawcy;
    }

    public Set<RezerwacjeUslugerow> getRezerwacjeUslugerows() {
        return rezerwacjeUslugerows;
    }

    public void setRezerwacjeUslugerows(Set<RezerwacjeUslugerow> rezerwacjeUslugerows) {
        this.rezerwacjeUslugerows = rezerwacjeUslugerows;
    }

    public Set<OcenyKlientow> getOcenyKlientows() {
        return ocenyKlientows;
    }

    public void setOcenyKlientows(Set<OcenyKlientow> ocenyKlientows) {
        this.ocenyKlientows = ocenyKlientows;
    }

    public ModelePracy getIdModelu() {
        return idModelu;
    }

    public void setIdModelu(ModelePracy idModelu) {
        this.idModelu = idModelu;
    }

    public Salony getIdSalonu() {
        return idSalonu;
    }

    public void setIdSalonu(Salony idSalonu) {
        this.idSalonu = idSalonu;
    }

    public Boolean getCzyPracuje() {
        return czyPracuje;
    }

    public void setCzyPracuje(Boolean czyPracuje) {
        this.czyPracuje = czyPracuje;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
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