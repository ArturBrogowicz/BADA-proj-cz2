package com.badabdd.beautysal00n.repositories;

import com.badabdd.beautysal00n.entities.ZakupyProduktow;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZakupyProduktowRepository extends CrudRepository<ZakupyProduktow, Integer> {
}
