package com.badabdd.beautysal00n.entities;

import jakarta.validation.constraints.NotNull;

public record IdWykorzystana(
        @NotNull
        Integer idUslugi,
        @NotNull
        Integer idNarzedzia
) {
}
