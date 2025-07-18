package com.example.gestionePrenotazioni.services;

import com.example.gestionePrenotazioni.entities.Postazione;
import com.example.gestionePrenotazioni.entities.Prenotazione;
import com.example.gestionePrenotazioni.repositories.PostazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostazioneService {

    @Autowired
    PostazioneRepository postazioneRepository;

    public List<Postazione> getAllPostazioni(){
        return postazioneRepository.findAll();
    }

    public Postazione addPostazioni(Postazione postazione){
        return postazioneRepository.save(postazione);
    }
}
