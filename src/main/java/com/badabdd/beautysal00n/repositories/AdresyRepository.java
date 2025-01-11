package com.badabdd.beautysal00n.repositories;

import com.badabdd.beautysal00n.entities.Adresy;
import com.badabdd.beautysal00n.entities.ModelePracy;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdresyRepository extends ListCrudRepository<Adresy, Integer> {
    Adresy findByIdAdresu(Integer idAdresu);
    @Query("SELECT * FROM ADRESY WHERE miasto = :miasto AND ulica = :ulica AND kod_pocztowy = :kodPocztowy AND nr_budynku = :nrBudynku AND nr_lokalu = :nrLokalu")
    Adresy findByAttributes(@Param("miasto") String miasto, @Param("ulica")String ulica,
                            @Param("kodPocztowy")String kodPocztowy, @Param("nrBudynku")Integer nrBudynku,
                            @Param("nrLokalu")Integer nrLokalu);
}
