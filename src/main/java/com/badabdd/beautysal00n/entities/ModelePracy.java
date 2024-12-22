package com.badabdd.beautysal00n.entities;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;

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
