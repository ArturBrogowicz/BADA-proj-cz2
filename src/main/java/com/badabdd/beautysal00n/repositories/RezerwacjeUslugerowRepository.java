package com.badabdd.beautysal00n.repositories;

import com.badabdd.beautysal00n.entities.RezerwacjeUslugerow;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface RezerwacjeUslugerowRepository extends CrudRepository<RezerwacjeUslugerow, Long> {
    @Query("SELECT COALESCE(MAX(id_rezerwacji), 0) FROM REZERWACJE_USLUGEROW")
    Integer getMaxId();

    @Modifying
    @Query("""
        INSERT INTO REZERWACJE_USLUGEROW (id_rezerwacji, id_pracownika, data)
        VALUES (:idRezerwacji, :idPracownika, :data)
    """)
    void insertRezerwacjaUslugerow(@Param("idRezerwacji") Integer idRezerwacji,
                                   @Param("idPracownika") Integer idPracownika,
                                   @Param("data") LocalDateTime data);

}
