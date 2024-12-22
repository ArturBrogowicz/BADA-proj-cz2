package com.badabdd.beautysal00n.entities;

import com.badabdd.beautysal00n.entities.enums.Plec;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record Klienci (
        @Id
        Integer idKlienta,
        @NotBlank
        String imie,
        @NotBlank
        String nazwisko,
        String nrTelefonu,
        Plec plec,
        @NotNull
        Integer idSalonu,
        Integer idAdresu
){
}
