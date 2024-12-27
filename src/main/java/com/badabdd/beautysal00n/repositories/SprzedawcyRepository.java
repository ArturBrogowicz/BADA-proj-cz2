package com.badabdd.beautysal00n.repositories;

import com.badabdd.beautysal00n.entities.Sprzedawcy;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SprzedawcyRepository extends ListCrudRepository<Sprzedawcy, Integer> {

    @Modifying
    @Query("""
            INSERT INTO sprzedawcy(id_pracownika, laczna_sprzedaz, liczba_transakcji)
            VALUES (:id_pracownika, :laczna_sprzedaz, :liczba_transakcji)
            """)
    void insertSprzedawca(@Param("id_pracownika") Integer idPracownika,
                          @Param("laczna_sprzedaz") Double lacznaSprzedaz,
                          @Param("liczba_transakcji") Integer liczbaTransakcji);

}
