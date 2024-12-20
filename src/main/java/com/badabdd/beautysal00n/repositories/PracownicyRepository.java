package com.badabdd.beautysal00n.repositories;

import com.badabdd.beautysal00n.entities_deprecated.Pracownicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PracownicyRepository extends JpaRepository<Pracownicy, Integer> {
    List<Pracownicy> findByNazwisko(String nazwisko);

    @Query("SELECT p FROM Pracownicy p " +
            "JOIN p.idModelu m " +
            "ORDER BY m.pensja DESC FETCH FIRST 1 ROWS ONLY")
    List<Pracownicy> findTopByPensja();

}
