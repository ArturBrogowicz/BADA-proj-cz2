package com.badabdd.beautysal00n.repositories;

import com.badabdd.beautysal00n.entities.Pracownicy;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PracownicyRepository extends ListCrudRepository<Pracownicy, Integer> {
    Pracownicy findByIdPracownika(Integer id);

    @Query(value = "SELECT * FROM PRACOWNICY WHERE CZY_PRACUJE = 1 FETCH FIRST 1 ROWS ONLY")
    Pracownicy findPracownikWhoPracuje();
}
