package com.badabdd.beautysal00n.entities;

import org.springframework.data.annotation.Id;

public record Uslugery (
        @Id
        Integer idPracownika,
        Integer sredniaOcen
) {
}
