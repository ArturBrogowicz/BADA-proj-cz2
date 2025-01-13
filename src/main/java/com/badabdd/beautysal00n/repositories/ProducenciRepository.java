package com.badabdd.beautysal00n.repositories;

import com.badabdd.beautysal00n.entities.Producenci;
import org.springframework.data.repository.ListCrudRepository;

public interface ProducenciRepository extends ListCrudRepository<Producenci, Integer> {

    Producenci findByIdProducenta(Integer id);
}
