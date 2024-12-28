package com.badabdd.beautysal00n.repositories;

import com.badabdd.beautysal00n.entities.Klienci;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KlienciRepository extends ListCrudRepository<Klienci, Integer> {
}
