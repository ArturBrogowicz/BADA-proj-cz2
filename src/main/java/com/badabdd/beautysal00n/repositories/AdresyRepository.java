package com.badabdd.beautysal00n.repositories;

import com.badabdd.beautysal00n.entities.Adresy;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdresyRepository extends ListCrudRepository<Adresy, Integer> {
    Adresy findByIdAdresu(Integer idAdresu);
}
