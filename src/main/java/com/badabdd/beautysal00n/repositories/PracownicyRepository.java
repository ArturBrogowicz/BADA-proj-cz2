package com.badabdd.beautysal00n.repositories;

import com.badabdd.beautysal00n.entities.Pracownicy;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PracownicyRepository extends ListCrudRepository<Pracownicy, Integer> {
}
