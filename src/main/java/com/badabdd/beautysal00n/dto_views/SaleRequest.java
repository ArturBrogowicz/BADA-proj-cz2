package com.badabdd.beautysal00n.dto_views;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record SaleRequest(
        Integer idProduktu,
        Integer amount,
        Integer idSprzedawcy,
        Integer idZakupyProduktow,
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime data,
        char czyDostawa,
        Integer idKlienta) {
}
