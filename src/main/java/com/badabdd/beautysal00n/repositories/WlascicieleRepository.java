package com.badabdd.beautysal00n.repositories;

import com.badabdd.beautysal00n.entities.Wlasciciele;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WlascicieleRepository extends ListCrudRepository<Wlasciciele, Integer> {

    public Wlasciciele findByIdWlasciciela(Integer id);
}
