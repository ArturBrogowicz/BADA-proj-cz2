package com.badabdd.beautysal00n.entities;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;

public record Producenci(
        @Id
        Integer idProducenta,
        @NotBlank
        String nazwa,
        @NotBlank
        String kodKraju,
        String email,
        String opis
) {
}
