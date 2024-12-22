package com.badabdd.beautysal00n.entities;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

public record ModelePracy (
        @Id
        Integer idModelu,
        @NotBlank
        String stanowisko,
        @NotBlank
        String trybPracy,
        @NotBlank
        Double pensja
) {
}
