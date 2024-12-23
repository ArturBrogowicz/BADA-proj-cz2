package com.badabdd.beautysal00n.repositories;

import com.badabdd.beautysal00n.entities.ModelePracy;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ModelePracyRepository extends ListCrudRepository<ModelePracy, Integer> {

    public ModelePracy findByIdModelu(Integer idModelu);
}
