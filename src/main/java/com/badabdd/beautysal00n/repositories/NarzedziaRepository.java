package com.badabdd.beautysal00n.repositories;

import com.badabdd.beautysal00n.entities.Narzedzia;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NarzedziaRepository extends ListCrudRepository<Narzedzia, Integer> {
}
