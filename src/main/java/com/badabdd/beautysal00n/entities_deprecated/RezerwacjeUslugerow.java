package com.badabdd.beautysal00n.entities_deprecated;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "REZERWACJE_USLUGEROW")
public class RezerwacjeUslugerow {
    @Id
    @Column(name = "ID_REZERWACJI", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PRACOWNIKA")
    private Pracownicy idPracownika;

    @Column(name = "\"DATA\"", nullable = false)
    private LocalDate data;

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pracownicy getIdPracownika() {
        return idPracownika;
    }

    public void setIdPracownika(Pracownicy idPracownika) {
        this.idPracownika = idPracownika;
    }

}