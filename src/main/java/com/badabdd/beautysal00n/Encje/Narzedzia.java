package com.badabdd.beautysal00n.Encje;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "NARZEDZIA")
public class Narzedzia {
    @Id
    @Column(name = "ID_NARZEDZIA", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_SALONU")
    private Salony idSalonu;

    @Column(name = "NAZWA", nullable = false, length = 30)
    private String nazwa;

    @Column(name = "CENA", nullable = false, precision = 10, scale = 2)
    private BigDecimal cena;

    @Column(name = "OPIS", nullable = false, length = 500)
    private String opis;

    @OneToMany(mappedBy = "idNarzedzia")
    private Set<WykorzystaneNarzedzia> wykorzystaneNarzedzias = new LinkedHashSet<>();

    public Set<WykorzystaneNarzedzia> getWykorzystaneNarzedzias() {
        return wykorzystaneNarzedzias;
    }

    public void setWykorzystaneNarzedzias(Set<WykorzystaneNarzedzia> wykorzystaneNarzedzias) {
        this.wykorzystaneNarzedzias = wykorzystaneNarzedzias;
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