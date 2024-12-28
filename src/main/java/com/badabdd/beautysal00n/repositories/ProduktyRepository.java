package com.badabdd.beautysal00n.repositories;

import com.badabdd.beautysal00n.entities.Produkty;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduktyRepository extends ListCrudRepository<Produkty, Integer> {

    Produkty findByIdProduktu(Integer id);
}
