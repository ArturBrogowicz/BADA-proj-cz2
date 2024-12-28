package com.badabdd.beautysal00n.repositories;

import com.badabdd.beautysal00n.entities.Uslugi;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UslugiRepository extends ListCrudRepository<Uslugi, Integer> {
    public Uslugi findByIdUslugi(Integer id);
}
