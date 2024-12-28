package com.badabdd.beautysal00n.repositories;
import com.badabdd.beautysal00n.entities.Uslugery;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UslugeryRepository extends ListCrudRepository<Uslugery,Integer> {

    @Modifying
    @Query("""
            INSERT INTO uslugery(id_pracownika, srednia_ocen)
            VALUES (:id_pracownika, :srednia_ocen)
            """)
    void insertUsluger(@Param("id_pracownika") Integer idPracownika,
                          @Param("srednia_ocen") Integer sredniaOcen);

    Uslugery findByIdPracownika(Integer idPracownika);
}
