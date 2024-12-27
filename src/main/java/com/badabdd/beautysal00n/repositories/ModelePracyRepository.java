package com.badabdd.beautysal00n.repositories;

import com.badabdd.beautysal00n.entities.ModelePracy;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelePracyRepository extends ListCrudRepository<ModelePracy, Integer> {

    public ModelePracy findByIdModelu(Integer idModelu);

    ModelePracy findByStanowisko(@NotBlank String stanowisko);
}
