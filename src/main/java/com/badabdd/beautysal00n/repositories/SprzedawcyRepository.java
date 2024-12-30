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
            SELECT * FROM SPRZEDAWCY WHERE ID_PRACOWNIKA = :idPracownika
            """)
    Sprzedawcy findSprzedawcyByIdPracownika(@Param("idPracownika") Integer idPracownika);

    @Modifying
    @Query("""
            INSERT INTO SPRZEDAWCY (ID_PRACOWNIKA, LACZNA_SPRZEDAZ, LICZBA_TRANSAKCJI)
            VALUES (:idPracownika, :lacznaSprzedaz, :liczbaTransakcji)
            """)
    void insertSprzedawca(@Param("idPracownika") Integer idPracownika,
                          @Param("lacznaSprzedaz") Double lacznaSprzedaz,
                          @Param("liczbaTransakcji") Integer liczbaTransakcji);
}

