package com.badabdd.beautysal00n.entities;

import jakarta.validation.constraints.NotNull;

public record IdWykonania (
        @NotNull
        Integer idUslugi,
        @NotNull
        Integer idNarzedzia
) {
}
