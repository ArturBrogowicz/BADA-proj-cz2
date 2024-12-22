package com.badabdd.beautysal00n.entities;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;

public record OcenyKlientow (
        @Id
        Integer idOceny,
        @NotNull
        Integer wysokosc,
        String tresc,
        @NotNull
        Integer idPracownika,
        @NotNull
        Integer idKlienta
) {
}
