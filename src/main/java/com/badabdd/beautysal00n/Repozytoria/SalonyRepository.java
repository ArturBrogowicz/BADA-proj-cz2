package com.badabdd.beautysal00n.Repozytoria;

import com.badabdd.beautysal00n.Encje.Salony;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SalonyRepository extends JpaRepository<Salony, Long> {
    List<Salony> findByNazwa(String nazwa);
}


