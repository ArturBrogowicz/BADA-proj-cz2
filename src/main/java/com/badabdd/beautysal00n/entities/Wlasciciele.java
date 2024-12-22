package com.badabdd.beautysal00n.entities;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;

public record Wlasciciele (
        @Id
        Integer idWlasciciela,
        @NotBlank
        String imie,
        @NotBlank
        String nazwisko,
        @NotNull
        Integer idSalonu,
        @NotNull
        Integer idAdresu
) {
}
