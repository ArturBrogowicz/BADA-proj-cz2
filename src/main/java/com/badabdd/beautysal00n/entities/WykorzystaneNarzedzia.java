package com.badabdd.beautysal00n.entities;

import org.springframework.data.annotation.Id;

public record WykorzystaneNarzedzia (
        @Id
        IdWykonania idWykonania
) {
}
