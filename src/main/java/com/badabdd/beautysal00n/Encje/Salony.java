package com.badabdd.beautysal00n.Encje;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "SALONY")
public class Salony {
    @Id
    @Column(name = "ID_SALONU", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ADRESU")
    private Adresy idAdresu;

    @Column(name = "NAZWA", nullable = false, length = 50)
    private String nazwa;

    @OneToMany(mappedBy = "idSalonu")
    private Set<Klienci> kliencis = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idSalonu")
    private Set<Narzedzia> narzedzias = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idSalonu")
    private Set<Pracownicy> pracownicies = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idSalonu")
    private Set<Produkty> produkties = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idSalonu")
    private Set<Uslugi> uslugis = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idSalonu")
    private Set<Wlasciciele> wlascicieles = new LinkedHashSet<>();

    public Set<Wlasciciele> getWlascicieles() {
        return wlascicieles;
    }

    public void setWlascicieles(Set<Wlasciciele> wlascicieles) {
        this.wlascicieles = wlascicieles;
    }

    public Set<Uslugi> getUslugis() {
        return uslugis;
    }

    public void setUslugis(Set<Uslugi> uslugis) {
        this.uslugis = uslugis;
    }

    public Set<Produkty> getProdukties() {
        return produkties;
    }

    public void setProdukties(Set<Produkty> produkties) {
        this.produkties = produkties;
    }

    public Set<Pracownicy> getPracownicies() {
        return pracownicies;
    }

    public void setPracownicies(Set<Pracownicy> pracownicies) {
        this.pracownicies = pracownicies;
    }

    public Set<Narzedzia> getNarzedzias() {
        return narzedzias;
    }

    public void setNarzedzias(Set<Narzedzia> narzedzias) {
        this.narzedzias = narzedzias;
    }

    public Set<Klienci> getKliencis() {
        return kliencis;
    }

    public void setKliencis(Set<Klienci> kliencis) {
        this.kliencis = kliencis;
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

    public Adresy getIdAdresu() {
        return idAdresu;
    }

    public void setIdAdresu(Adresy idAdresu) {
        this.idAdresu = idAdresu;
    }

}