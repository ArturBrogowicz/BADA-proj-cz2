package com.badabdd.beautysal00n.repositories;

import com.badabdd.beautysal00n.entities.Uslugi;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UslugiRepository {
    List<Uslugi> findById(Integer id);
    void update(Uslugi uslugi);
}
