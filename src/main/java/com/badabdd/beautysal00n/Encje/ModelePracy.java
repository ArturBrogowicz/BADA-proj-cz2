package com.badabdd.beautysal00n.Encje;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "MODELE_PRACY")
public class ModelePracy {
    @Id
    @Column(name = "ID_MODELU", nullable = false)
    private Long id;

    @Column(name = "STANOWISKO", nullable = false, length = 30)
    private String stanowisko;

    @Column(name = "TRYB_PRACY", nullable = false, length = 30)
    private String trybPracy;

    @Column(name = "PENSJA", nullable = false, precision = 10, scale = 2)
    private BigDecimal pensja;

    @OneToMany(mappedBy = "idModelu")
    private Set<Pracownicy> pracownicies = new LinkedHashSet<>();

    public Set<Pracownicy> getPracownicies() {
        return pracownicies;
    }

    public void setPracownicies(Set<Pracownicy> pracownicies) {
        this.pracownicies = pracownicies;
    }

    public BigDecimal getPensja() {
        return pensja;
    }

    public void setPensja(BigDecimal pensja) {
        this.pensja = pensja;
    }

    public String getTrybPracy() {
        return trybPracy;
    }

    public void setTrybPracy(String trybPracy) {
        this.trybPracy = trybPracy;
    }

    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}