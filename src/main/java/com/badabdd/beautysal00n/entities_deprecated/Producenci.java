package com.badabdd.beautysal00n.entities_deprecated;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "PRODUCENCI")
public class Producenci {
    @Id
    @Column(name = "ID_PRODUCENTA", nullable = false)
    private Long id;

    @Column(name = "NAZWA", nullable = false, length = 40)
    private String nazwa;

    @Column(name = "KOD_KRAJU", nullable = false, length = 2)
    private String kodKraju;

    @Column(name = "ADRES_EMAIL", length = 40)
    private String adresEmail;

    @Column(name = "OPIS", length = 2500)
    private String opis;

    @OneToMany(mappedBy = "idProducenta")
    private Set<Produkty> produkties = new LinkedHashSet<>();

    public Set<Produkty> getProdukties() {
        return produkties;
    }

    public void setProdukties(Set<Produkty> produkties) {
        this.produkties = produkties;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getAdresEmail() {
        return adresEmail;
    }

    public void setAdresEmail(String adresEmail) {
        this.adresEmail = adresEmail;
    }

    public String getKodKraju() {
        return kodKraju;
    }

    public void setKodKraju(String kodKraju) {
        this.kodKraju = kodKraju;
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

}