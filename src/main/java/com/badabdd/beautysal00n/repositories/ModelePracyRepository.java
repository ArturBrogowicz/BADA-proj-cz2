package com.badabdd.beautysal00n.repositories;

import com.badabdd.beautysal00n.entities.ModelePracy;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelePracyRepository extends ListCrudRepository<ModelePracy, Integer> {

    public ModelePracy findByIdModelu(Integer idModelu);

    ModelePracy findByStanowisko(@NotBlank String stanowisko);

    @Query("SELECT * FROM MODELE_PRACY WHERE stanowisko = :stanowisko AND tryb_pracy = :trybPracy AND pensja = :pensja")
    ModelePracy findByAttributes(@Param("stanowisko") String stanowisko,
                                @Param("trybPracy") String trybPracy,
                                @Param("pensja") Double pensja);
}
