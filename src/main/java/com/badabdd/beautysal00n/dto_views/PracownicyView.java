package com.badabdd.beautysal00n.dto_views;

public record PracownicyView (
        String imie,
        String nazwisko,
        String pesel,
        String miasto,
        String ulica,
        String kodPocztowy,
        Integer nrBudynku,
        Integer nrLokalu,
        String stanowisko,
        String trybPracy,
        Double pensja
){}
