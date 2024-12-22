package com.badabdd.beautysal00n.entities;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public record RezerwacjeUslugerow(
        @Id
        Integer idRezerwacji,
        @NotNull
        Integer idPracownika,
        @NotNull
        LocalDateTime data
) {
}
