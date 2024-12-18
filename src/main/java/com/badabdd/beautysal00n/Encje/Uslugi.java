package com.badabdd.beautysal00n.Encje;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "USLUGI")
public class Uslugi {
    @Id
    @Column(name = "ID_USLUGI", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_SALONU")
    private Salony idSalonu;

    @Column(name = "NAZWA", nullable = false, length = 50)
    private String nazwa;

    @Column(name = "OPIS", nullable = false, length = 2500)
    private String opis;

    @Column(name = "KOSZT", nullable = false, precision = 10, scale = 2)
    private BigDecimal koszt;

    @Column(name = "CZY_OFEROWANA", nullable = false)
    private Boolean czyOferowana = false;

    public Boolean getCzyOferowana() {
        return czyOferowana;
    }

    public void setCzyOferowana(Boolean czyOferowana) {
        this.czyOferowana = czyOferowana;
    }

    public BigDecimal getKoszt() {
        return koszt;
    }

    public void setKoszt(BigDecimal koszt) {
        this.koszt = koszt;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
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