package com.example.gestionePrenotazioni.repositories;

import com.example.gestionePrenotazioni.entities.Edificio;
import com.example.gestionePrenotazioni.entities.Postazione;
import com.example.gestionePrenotazioni.enums.Tipo_postazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione,Long> {

    @Query("SELECT p from Postazione p WHERE p.tipo = :tipo AND p.edificio.città=:città" )
    List<Postazione> postazioniPerTipoeCitta(@Param("tipo") Tipo_postazione tipo, @Param("città") String città);
}
