package com.example.gestionePrenotazioni.services;

import com.example.gestionePrenotazioni.entities.Prenotazione;
import com.example.gestionePrenotazioni.entities.Utente;
import com.example.gestionePrenotazioni.repositories.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrenotazioneService {

    @Autowired
    PrenotazioneRepository prenotazioneRepository;

    public List<Prenotazione> getAllPrenotazioni(){
        return prenotazioneRepository.findAll();
    }

    public Prenotazione addPrenotazioni(Prenotazione prenotazione){
        return prenotazioneRepository.save(prenotazione);
    }
}
