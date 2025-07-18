package com.example.gestionePrenotazioni.services;

import com.example.gestionePrenotazioni.entities.Postazione;
import com.example.gestionePrenotazioni.entities.Prenotazione;
import com.example.gestionePrenotazioni.entities.Utente;
import com.example.gestionePrenotazioni.exceptions.NotFoundException;
import com.example.gestionePrenotazioni.repositories.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrenotazioneService {

    @Autowired
    PrenotazioneRepository prenotazioneRepository;

    public List<Prenotazione> getAllPrenotazioni() {

        prenotazioneRepository.eliminaPrenotazioniScadute(LocalDate.now());


        return prenotazioneRepository.findAll();
    }

    public Prenotazione findById(long id){
        return prenotazioneRepository.findById(id).orElseThrow(()->new NotFoundException(id));
    }


    public void effettuaPrenotazione(Utente utente, Postazione postazione) {
        if (prenotazioneRepository.numeroPrenotazioniPerPostazione(postazione) < postazione.getCapienza()) {

            if (prenotazioneRepository.numeroPrenotazioniUtentePerPostazione(postazione, utente) < 1) {

                Prenotazione prenotazione = new Prenotazione(LocalDate.now(), utente, postazione);
                prenotazioneRepository.save(prenotazione);
            } else {
                System.out.println("Hai già una prenotazione per questa postazione");
            }
        } else {
            System.out.println("I posti sono terminati");
        }
    }

}