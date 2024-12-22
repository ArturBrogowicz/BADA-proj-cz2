package com.badabdd.beautysal00n.entities;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public record ZakupyProduktow (
        @Id
        Integer idZakupu,
        @NotNull
        LocalDateTime data,
        @NotNull
        char czyDostawa,
        @NotNull
        Integer idKlienta,
        @NotNull
        Integer idProduktu,
        Integer idPracownika
) {
}
