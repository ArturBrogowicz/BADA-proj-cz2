package com.badabdd.beautysal00n.repositories;

import com.badabdd.beautysal00n.entities.Pracownicy;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface PracownicyRepository extends ListCrudRepository<Pracownicy, Integer> {
}
