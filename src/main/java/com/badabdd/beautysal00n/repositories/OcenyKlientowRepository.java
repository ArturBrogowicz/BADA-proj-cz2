package com.badabdd.beautysal00n.repositories;

import com.badabdd.beautysal00n.entities.OcenyKlientow;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OcenyKlientowRepository extends ListCrudRepository<OcenyKlientow, Integer> {

    List<OcenyKlientow> findAllByIdPracownika(Integer idPracownika);
}
