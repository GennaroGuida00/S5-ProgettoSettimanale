package com.example.gestionePrenotazioni.repositories;

import com.example.gestionePrenotazioni.entities.Postazione;
import com.example.gestionePrenotazioni.entities.Prenotazione;
import com.example.gestionePrenotazioni.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione,Long> {


    @Modifying
    @Query("DELETE FROM Prenotazione p WHERE p.data < :oggi")
    void eliminaPrenotazioniScadute(@Param("oggi")LocalDate oggi);


    @Query("SELECT COUNT(p) from Prenotazione p WHERE p.postazione = :postazione" )
    int numeroPrenotazioniPerPostazione(@Param("postazione")Postazione postazione);

    @Query("SELECT COUNT(p) from Prenotazione p WHERE p.postazione = :postazione AND p.utente=:utente" )
    int numeroPrenotazioniUtentePerPostazione(@Param("postazione")Postazione postazione,@Param("utente")Utente utente);
}
