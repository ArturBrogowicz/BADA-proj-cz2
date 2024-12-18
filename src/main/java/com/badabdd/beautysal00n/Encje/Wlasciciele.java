package com.badabdd.beautysal00n.Encje;

import jakarta.persistence.*;

@Entity
@Table(name = "WLASCICIELE")
public class Wlasciciele {
    @Id
    @Column(name = "ID_WLASCICIELA", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ADRESU")
    private Adresy idAdresu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_SALONU")
    private Salony idSalonu;

    @Column(name = "IMIE", nullable = false, length = 20)
    private String imie;

    @Column(name = "NAZWISKO", nullable = false, length = 20)
    private String nazwisko;

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

    public Salony getIdSalonu() {
        return idSalonu;
    }

    public void setIdSalonu(Salony idSalonu) {
        this.idSalonu = idSalonu;
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