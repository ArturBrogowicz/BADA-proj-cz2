package com.badabdd.beautysal00n.repositories;

import com.badabdd.beautysal00n.entities.WykonanieUslug;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface WykonanieUslugRepository extends ListCrudRepository<WykonanieUslug, Integer> {

    @Modifying
    @Query("""
        INSERT INTO WYKONANIE_USLUG (id_wykonania, data, czas_trwania, id_uslugi, id_klienta, id_pracownika)
        VALUES (:idWykonania, :data, :czasTrwania, :idUslugi, :idKlienta, :idPracownika)
    """)
    void insertWykonanieUslugi(@Param("idWykonania") Integer idWykonania,
                               @Param("data") LocalDateTime data,
                               @Param("czasTrwania") Integer czasTrwania,
                               @Param("idUslugi") Integer idUslugi,
                               @Param("idKlienta") Integer idKlienta,
                               @Param("idPracownika") Integer idPracownika);
    @Query("SELECT COALESCE(MAX(id_wykonania), 0) FROM WYKONANIE_USLUG")
    Integer getMaxId();

}

