package com.badabdd.beautysal00n.entities;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;

public record Salony (
        @Id
        Integer idSalonu,
        @NotBlank
        String nazwa,
        @NotNull
        Integer idAdresu
) {
}
