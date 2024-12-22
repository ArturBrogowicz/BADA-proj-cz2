package com.badabdd.beautysal00n.entities;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;

public record Sprzedawcy (
        @Id
        Integer idPracownika,
        @NotNull
        Double lacznaSprzedaz,
        @NotNull
        Integer liczbaTransakcji
) {
}
