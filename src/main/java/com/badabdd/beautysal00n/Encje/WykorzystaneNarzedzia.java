package com.badabdd.beautysal00n.Encje;

import jakarta.persistence.*;

@Entity
@Table(name = "WYKORZYSTANE_NARZEDZIA")
public class WykorzystaneNarzedzia {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_NARZEDZIA")
    private Narzedzia idNarzedzia;

    @Column(name = "ID_USLUGI", nullable = false)
    private Long idUslugi;

    public Long getIdUslugi() {
        return idUslugi;
    }

    public void setIdUslugi(Long idUslugi) {
        this.idUslugi = idUslugi;
    }

    public Narzedzia getIdNarzedzia() {
        return idNarzedzia;
    }

    public void setIdNarzedzia(Narzedzia idNarzedzia) {
        this.idNarzedzia = idNarzedzia;
    }

}