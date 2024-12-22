package com.badabdd.beautysal00n.entities;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;

public record Produkty (
        @Id
        Integer idProduktu,
        @NotBlank
        String nazwa,
        @NotNull
        Double cena,
        @NotBlank
        String opis,
        @NotNull
        Integer liczbaSztuk,
        @NotNull
        char czyOferowany,
        @NotNull
        Integer idProducenta,
        @NotNull
        Integer idSalonu
) {
}
