package com.badabdd.beautysal00n.dto_views;

import java.time.LocalDateTime;

public record ReservationRequest(Integer idUslugi,
                                 Integer idKlienta,
                                 LocalDateTime data,
                                 Integer czasTrwania) {
}
