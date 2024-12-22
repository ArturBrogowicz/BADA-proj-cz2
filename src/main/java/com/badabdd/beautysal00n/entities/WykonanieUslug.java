package com.badabdd.beautysal00n.entities;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public record WykonanieUslug (
        @Id
        Integer idWykonania,
        @NotNull
        LocalDateTime data,
        Integer czasTrwania,
        @NotNull
        Integer idUslugi,
        @NotNull
        Integer idKlienta,
        Integer idPracownika
) {
}
