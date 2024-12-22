package com.badabdd.beautysal00n.entities;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;

public record Pracownicy(
        @Id
        Integer idPracownika,
        @NotBlank
        String imie,
        @NotBlank
        String nazwisko,
        String pesel,
        char czyPracuje,
        @NotNull
        Integer idSalonu,
        @NotNull
        Integer idModelu,
        @NotNull
        Integer idAdresu
) {
}
